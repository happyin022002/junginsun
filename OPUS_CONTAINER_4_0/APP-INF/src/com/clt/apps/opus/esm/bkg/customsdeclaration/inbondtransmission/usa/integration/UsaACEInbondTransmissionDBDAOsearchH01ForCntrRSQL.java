/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaACEInbondTransmissionDBDAOsearchH01ForCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACEInbondTransmissionDBDAOsearchH01ForCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaACEInbondTransmissionDBDAOsearchH01ForCntrRSQL
	  * </pre>
	  */
	public UsaACEInbondTransmissionDBDAOsearchH01ForCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACEInbondTransmissionDBDAOsearchH01ForCntrRSQL").append("\n"); 
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
		query.append("SELECT RPAD('H01'||@[flag2]||RPAD(@[cntr_no],14,' ')" ).append("\n"); 
		query.append("             ||RPAD(to_char(to_date(replace(replace(@[arr_dt],'-',''),'/',''),'yyyymmdd'),'rrmmdd'),6,' ')" ).append("\n"); 
		query.append("             ||RPAD(LOC_AMS_PORT_CD,4,' ')||COM_ConstantMgr_PKG.COM_getScacCode_FNC()" ).append("\n"); 
		query.append("             ||RPAD(DECODE(NVL(replace(@[arr_time],':',''),'0001'),'0000','0001',replace(@[arr_time],':','')), 6, '00') ,80,' ')" ).append("\n"); 
		query.append("             ||CHR(10)||" ).append("\n"); 
		query.append("       RPAD('H02'||'IB'|| RPAD(@[ibd_trsp_no], 16, ' ') || " ).append("\n"); 
		query.append("       RPAD(' ', 23, ' ')" ).append("\n"); 
		query.append("       || ' ',80,' ')||CHR(10)" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}