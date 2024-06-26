/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchClrTpSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.09.17 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchClrTpSetupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchClrTpSetup - Entry Tpye Setup에 저장된 값 조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchClrTpSetupRSQL(){
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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchClrTpSetupRSQL").append("\n"); 
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
		query.append("SELECT  CLR.CUST_CNT_CD || CLR.CUST_SEQ AS CUST_CD" ).append("\n"); 
		query.append("       ,CST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("       ,CLR.SC_NO" ).append("\n"); 
		query.append("       ,CLR.POD_CD" ).append("\n"); 
		query.append("       ,CLR.DEL_CD" ).append("\n"); 
		query.append("       ,CLR.CLR_TP_SEQ" ).append("\n"); 
		query.append("       ,CLR.CMDT_CD" ).append("\n"); 
		query.append("       ,CMD.CMDT_NM" ).append("\n"); 
		query.append("       ,CLR.CNTR_TP_CD" ).append("\n"); 
		query.append("       ,CLR.FREE_TRD_ZN_FLG AS FTZ_FLG" ).append("\n"); 
		query.append("       ,CLR.CSTMS_CLR_TP_CD AS ETR_TP" ).append("\n"); 
		query.append("       ,CLR.CRE_DT" ).append("\n"); 
		query.append("       ,CLR.CRE_USR_ID" ).append("\n"); 
		query.append("       ,CLR.CRE_OFC_CD" ).append("\n"); 
		query.append("       ,CLR.UPD_DT" ).append("\n"); 
		query.append("       ,CLR.UPD_USR_ID" ).append("\n"); 
		query.append("       ,CLR.UPD_OFC_CD" ).append("\n"); 
		query.append("       ,CLR.DELT_FLG" ).append("\n"); 
		query.append("       ,CLR.DELT_DT" ).append("\n"); 
		query.append("       ,CLR.DELT_USR_ID" ).append("\n"); 
		query.append("       ,CLR.HUB_LOC_CD" ).append("\n"); 
		query.append("	   ,CLR.IBD_TRSP_TP_CD AS IT_TP" ).append("\n"); 
		query.append("	   ,CLR.CSTMS_LOC_CD" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_CLR_TP CLR" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER CST" ).append("\n"); 
		query.append("       ,MDM_COMMODITY CMD" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     CLR.CUST_CNT_CD     = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND     CLR.CUST_SEQ        = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("AND     NVL(CLR.SC_NO ,'NL')IN ('NL' , @[sc_no])" ).append("\n"); 
		query.append("AND     CLR.POD_CD          = @[pod_cd]" ).append("\n"); 
		query.append("AND     CLR.DEL_CD          IN ('ALL', @[del_cd])" ).append("\n"); 
		query.append("AND     CLR.CUST_CNT_CD     = CST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND     CLR.CUST_SEQ        = CST.CUST_SEQ" ).append("\n"); 
		query.append("AND     CLR.CMDT_CD         = CMD.CMDT_CD(+)" ).append("\n"); 
		query.append("AND     CLR.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("ORDER BY CLR.DEL_CD DESC" ).append("\n"); 

	}
}