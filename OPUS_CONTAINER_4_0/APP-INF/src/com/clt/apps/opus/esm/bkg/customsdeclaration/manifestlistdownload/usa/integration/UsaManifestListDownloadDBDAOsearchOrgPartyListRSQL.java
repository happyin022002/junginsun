/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchOrgPartyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.07.13 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchOrgPartyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SNP/Broker Nomination  조회 :BKG_CSTMS_ADV_ORZ_PTY
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchOrgPartyListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchOrgPartyListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  A.CUST_CNT_CD," ).append("\n"); 
		query.append("  A.CUST_SEQ," ).append("\n"); 
		query.append("  A.CUST_CNT_CD||A.CUST_SEQ CUST_CD," ).append("\n"); 
		query.append("  (SELECT M.CUST_LGL_ENG_NM FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("   WHERE M.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND   M.CUST_SEQ = A.CUST_SEQ )CUST_NM," ).append("\n"); 
		query.append("  A.SC_NO," ).append("\n"); 
		query.append("  A.POD_CD," ).append("\n"); 
		query.append("  A.POD_YD_NO," ).append("\n"); 
		query.append("  A.DEL_CD," ).append("\n"); 
		query.append("  A.DEL_YD_NO, " ).append("\n"); 
		query.append("  A.CSTMS_PTY_SEQ," ).append("\n"); 
		query.append("  A.CSTMS_PTY_TP_CD, " ).append("\n"); 
		query.append("  A.CSTMS_PTY_NM," ).append("\n"); 
		query.append("  A.CSTMS_PTY_ID, " ).append("\n"); 
		query.append("  A.DELT_FLG," ).append("\n"); 
		query.append("  A.CRE_OFC_CD," ).append("\n"); 
		query.append("  A.UPD_OFC_CD," ).append("\n"); 
		query.append("  A.CRE_USR_ID ," ).append("\n"); 
		query.append("  A.CRE_DT," ).append("\n"); 
		query.append("  A.UPD_USR_ID," ).append("\n"); 
		query.append("  A.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_ORZ_PTY A" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cust_cd} != '') " ).append("\n"); 
		query.append("AND  A.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '') " ).append("\n"); 
		query.append("AND  A.CUST_SEQ = SUBSTR(@[cust_cd],3,6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND  A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND DECODE( A.POD_CD,'ALL',@[pod_cd] , A.POD_CD) = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("AND DECODE( A.DEL_CD,'ALL',@[del_cd] , A.DEL_CD ) = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '') " ).append("\n"); 
		query.append("AND  A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CUST_CNT_CD, " ).append("\n"); 
		query.append("         A.CUST_SEQ," ).append("\n"); 
		query.append("         A.POD_CD, A.POD_YD_NO," ).append("\n"); 
		query.append("         A.DEL_CD, A.DEL_YD_NO," ).append("\n"); 
		query.append("         A.CSTMS_PTY_SEQ" ).append("\n"); 

	}
}