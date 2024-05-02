/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCmdtFakRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.13 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCmdtFakRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * F.A.K 여부 확인
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCmdtFakRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCmdtFakRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select case when @[cmdt_cd] = 4 then 'Y' --4는 전지역 가능" ).append("\n"); 
		query.append("when por.conti_cd <> 'A' then 'N' --origin이 asia이외 지역 4가 아니면 불가" ).append("\n"); 
		query.append("when por.conti_cd =  'A' and (del.sconti_cd = 'MN' or del.sconti_cd = 'MC') then 'Y' --ASIA -> 북미는 전부 가능" ).append("\n"); 
		query.append("when por.conti_cd =  'A' and (del.sconti_cd <> 'MN' and del.sconti_cd <> 'MC') then 'N' --ASIA -> 북미 이외 지역은 4가 아니면 불가" ).append("\n"); 
		query.append("end result" ).append("\n"); 
		query.append("from MDM_location por" ).append("\n"); 
		query.append(", MDM_location del" ).append("\n"); 
		query.append("where por.loc_cd = @[por_cd]" ).append("\n"); 
		query.append("and del.loc_cd = @[del_cd]" ).append("\n"); 

	}
}