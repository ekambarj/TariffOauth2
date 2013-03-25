package uk.co.o2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import uk.co.o2.exception.TariffNotFoundException;

import uk.co.o2.vo.Tariff;

public class TariffDAO {
	
	/**
	 * Private constructor to avoid instance creation
	 */
	private TariffDAO()
	{
		
	}
	

	private static String tariffName[]={"O2 Lease 200 12 month Premier","O2 Lease 1200 12 month Premier","O2 Lease 20 12 month Tablet","O2 Lease 25 12 month Tablet"};
	private static HashMap<String, Tariff> tariffsMap = new HashMap<String, Tariff>();
	
	private static int tariffID = 0;
	
	private static String EMPTY_STRING = "";
	
	static {
		for (; tariffID < 4; tariffID ++)
			tariffsMap.put(tariffID + EMPTY_STRING,
					getTariffVO());
	}
	
	/**
	 * Constructs tariff vo
	 * @return tariffVO
	 */
	private static Tariff getTariffVO() {
		Tariff tariff = new Tariff();
		tariff.setTariffDuration(tariffID+"");
		tariff.setTariffID(tariffID+"");
		tariff.setTariffDescription(tariffName[tariffID]);
		tariff.setTariffName(tariffName[tariffID]);
		tariff.setTariffStatus("Active");
		

		return tariff;
	}
	
	/**
	 * Returns tariff details for the given tariff ID
	 * @param tariffID : The tariffID
	 * @return
	 */
	public static Tariff getTariffDetail(String tariffID) throws TariffNotFoundException
	{
		Tariff tariffvo =tariffsMap.get(tariffID); 
		if(null == tariffvo)
		{
			throw new TariffNotFoundException("Tariff Not found");
		}
		return tariffvo; 
	}
	
	public static List<Tariff> getTariffList()
	{
		ArrayList<Tariff> tariffList = new ArrayList<Tariff>();
		tariffList.addAll(tariffsMap.values());
		
		return tariffList;
	}
	
	public static void addTariff(Tariff tariff)
	{
		tariff.setTariffID(tariff.getTariffID());
		tariffsMap.put(tariff.getTariffID(), tariff);
		
	}
	
	public static void updateTariff(Tariff tariff) {
		tariffsMap.put(tariff.getTariffID(), tariff);
	}
	
	public static void deleteTariff(String tariffID)throws TariffNotFoundException
	{
		if(null == tariffsMap.remove(tariffID))
		{
			throw new TariffNotFoundException("Tariff details not found");
		}
	}

}
