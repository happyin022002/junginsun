/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchHandlingOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.01.22 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchHandlingOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-BKG Handling Office 를 조회한다.
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchHandlingOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_hndl_ofc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vt_cust_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vt_cust_ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchHandlingOfficeRSQL").append("\n"); 
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
		query.append("#if(${insert_check} == 'check')" ).append("\n"); 
		query.append("SELECT BKG_HNDL_OFC_SEQ," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	HNDL_OFC_CD," ).append("\n"); 
		query.append("	POR_CD," ).append("\n"); 
		query.append("	CUST_CNT_CD || LPAD( CUST_SEQ, 6, '0' ) AS CUST_CD," ).append("\n"); 
		query.append("	CUST_CNT_CD," ).append("\n"); 
		query.append(" 	CUST_SEQ," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	VT_CUST_OFC_CD," ).append("\n"); 
		query.append("	VT_CUST_CNT_CD," ).append("\n"); 
		query.append("	VT_CUST_OFC_NM," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_HNDL_OFC_STUP HNOS" ).append("\n"); 
		query.append("WHERE HNOS.BKG_HNDL_OFC_SEQ <> NVL(@[bkg_hndl_ofc_seq],0)" ).append("\n"); 
		query.append("AND   NVL(HNOS.VT_CUST_OFC_CD,'ZZZZZ//') = NVL(DECODE(@[vt_cust_ofc_cd], 'null' , '', @[vt_cust_ofc_cd]),'ZZZZZ//')" ).append("\n"); 
		query.append("AND   NVL(HNOS.POR_CD,'ZZZZZ') = NVL(DECODE(@[por_cd], 'null' , '', @[por_cd]),'ZZZZZ')" ).append("\n"); 
		query.append("AND   NVL(HNOS.POL_CD,'ZZZZZ') = NVL(DECODE(@[pol_cd], 'null' , '', @[pol_cd]),'ZZZZZ') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_HNDL_OFC_SEQ," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	HNDL_OFC_CD," ).append("\n"); 
		query.append("	POR_CD," ).append("\n"); 
		query.append("	CUST_CNT_CD || LPAD( CUST_SEQ, 6, '0' ) AS CUST_CD," ).append("\n"); 
		query.append("	CUST_CNT_CD," ).append("\n"); 
		query.append(" 	CUST_SEQ," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	VT_CUST_OFC_CD," ).append("\n"); 
		query.append("	VT_CUST_CNT_CD," ).append("\n"); 
		query.append("	VT_CUST_OFC_NM," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_HNDL_OFC_STUP" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${hndl_ofc_cd} != '')" ).append("\n"); 
		query.append("AND HNDL_OFC_CD = @[hndl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_cd} != '')" ).append("\n"); 
		query.append("AND POL_CD  = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${por_cd} != '')" ).append("\n"); 
		query.append("AND POR_CD  = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vt_cust_ofc_cd} != '')" ).append("\n"); 
		query.append("AND VT_CUST_OFC_CD = @[vt_cust_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vt_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND VT_CUST_CNT_CD LIKE @[vt_cust_cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vt_cust_ofc_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(VT_CUST_OFC_NM) LIKE '%' || UPPER(@[vt_cust_ofc_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY HNDL_OFC_CD, POL_CD, POR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}