/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgZipCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2010.12.20 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgZipCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Zip Code list
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgZipCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_dtl_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgZipCdVORSQL").append("\n"); 
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
		query.append("SELECT  A.CNT_CD" ).append("\n"); 
		query.append("       ,A.ZIP_CD" ).append("\n"); 
		query.append("       ,A.CTY_NM" ).append("\n"); 
		query.append("       ,A.STE_NM" ).append("\n"); 
		query.append("       ,A.ZIP_DTL_ADDR" ).append("\n"); 
		query.append("       ,A.EVNT_USR_ID" ).append("\n"); 
		query.append("       ,B.USR_NM" ).append("\n"); 
		query.append("       ,A.EVNT_OFC_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.EVNT_DT,'YYYY-MM-DD') as EVNT_DT" ).append("\n"); 
		query.append("       ,A.EVNT_GDT" ).append("\n"); 
		query.append("       ,A.DELT_FLG" ).append("\n"); 
		query.append(" FROM  BKG_ZIP_CD A," ).append("\n"); 
		query.append("       COM_USER B" ).append("\n"); 
		query.append("WHERE A.EVNT_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("AND	nvl(A.DELT_FLG,'N') IN ( 'N' , @[delt_flg])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	nvl(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND	A.CNT_CD  = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zip_cd} != '') " ).append("\n"); 
		query.append("AND	A.ZIP_CD  like '%'||@[zip_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cty_nm} != '') " ).append("\n"); 
		query.append("AND	A.CTY_NM  like '%'||@[cty_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ste_nm} != '') " ).append("\n"); 
		query.append("AND	A.STE_NM  like '%'||@[ste_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zip_dtl_addr} != '') " ).append("\n"); 
		query.append("AND	A.ZIP_DTL_ADDR  like '%'||@[zip_dtl_addr]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}