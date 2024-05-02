/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgZipCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.01
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.08.01 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
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
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        CNT_CD" ).append("\n"); 
		query.append("       ,ZIP_CD" ).append("\n"); 
		query.append("       ,CTY_NM" ).append("\n"); 
		query.append("       ,STE_NM" ).append("\n"); 
		query.append("       ,ZIP_DTL_ADDR" ).append("\n"); 
		query.append("       ,EVNT_USR_ID" ).append("\n"); 
		query.append("       ,USR_NM" ).append("\n"); 
		query.append("       ,EVNT_OFC_CD" ).append("\n"); 
		query.append("       ,EVNT_DT" ).append("\n"); 
		query.append("       ,EVNT_GDT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("	   ,ZIP_CD_SEQ" ).append("\n"); 
		query.append("       ,NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
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
		query.append("	   ,A.ZIP_CD_SEQ" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER (ORDER BY A.ZIP_CD ASC) NO" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append("#if (${ipage} != 0 ) " ).append("\n"); 
		query.append("	WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}