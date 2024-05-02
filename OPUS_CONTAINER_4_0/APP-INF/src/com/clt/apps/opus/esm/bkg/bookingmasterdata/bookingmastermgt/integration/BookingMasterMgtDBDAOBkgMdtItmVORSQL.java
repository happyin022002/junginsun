/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgMdtItmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.12.01 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgMdtItmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgMdtItmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgMdtItmVORSQL").append("\n"); 
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
		query.append("/* BkgMdtItmVO */" ).append("\n"); 
		query.append("#if (${VO} == 'VO')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' MDT_ITM_SEQ," ).append("\n"); 
		query.append("'' BKG_MDT_CATE_CD," ).append("\n"); 
		query.append("'' CUST_GRP_ID," ).append("\n"); 
		query.append("'' MDT_CUST_TP_CD," ).append("\n"); 
		query.append("'' CUST_CNT_CD," ).append("\n"); 
		query.append("'' CUST_SEQ," ).append("\n"); 
		query.append("'' SC_NO," ).append("\n"); 
		query.append("'' RFA_NO," ).append("\n"); 
		query.append("'' SVC_SCP_CD," ).append("\n"); 
		query.append("'' POR_CD," ).append("\n"); 
		query.append("'' POL_CD," ).append("\n"); 
		query.append("'' POD_CD," ).append("\n"); 
		query.append("'' DEL_CD," ).append("\n"); 
		query.append("'' MDT_ITM_RMK," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT," ).append("\n"); 
		query.append("'' ITM_CD_POB," ).append("\n"); 
		query.append("'' ITM_NM_POB," ).append("\n"); 
		query.append("'' ITM_CD_POC," ).append("\n"); 
		query.append("'' ITM_NM_POC," ).append("\n"); 
		query.append("'' ITM_CD_POM," ).append("\n"); 
		query.append("'' ITM_NM_POM," ).append("\n"); 
		query.append("'' ITM_CD_INV," ).append("\n"); 
		query.append("'' ITM_NM_INV," ).append("\n"); 
		query.append("'' ITM_CD_DEP," ).append("\n"); 
		query.append("'' ITM_NM_DEP," ).append("\n"); 
		query.append("'' ITM_CD_LC," ).append("\n"); 
		query.append("'' ITM_NM_LC," ).append("\n"); 
		query.append("'' ITM_CD_SHP," ).append("\n"); 
		query.append("'' ITM_NM_SHP," ).append("\n"); 
		query.append("'' ITM_CD_PAT," ).append("\n"); 
		query.append("'' ITM_NM_PAT," ).append("\n"); 
		query.append("'' ITM_CD_INC," ).append("\n"); 
		query.append("'' ITM_NM_INC," ).append("\n"); 
		query.append("'' BKG_MDT_ITM_CD," ).append("\n"); 
		query.append("'' FCUST," ).append("\n"); 
		query.append("'' SC_EXP_DT," ).append("\n"); 
		query.append("'' RFA_EXP_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.MDT_ITM_SEQ" ).append("\n"); 
		query.append(",    A.BKG_MDT_CATE_CD" ).append("\n"); 
		query.append(",    A.CUST_GRP_ID" ).append("\n"); 
		query.append(",    A.MDT_CUST_TP_CD" ).append("\n"); 
		query.append(",    A.CUST_CNT_CD" ).append("\n"); 
		query.append(",    A.CUST_SEQ" ).append("\n"); 
		query.append(",    A.SC_NO" ).append("\n"); 
		query.append(",    A.RFA_NO" ).append("\n"); 
		query.append(",    A.SVC_SCP_CD" ).append("\n"); 
		query.append(",    A.POR_CD" ).append("\n"); 
		query.append(",    A.POL_CD" ).append("\n"); 
		query.append(",    A.POD_CD" ).append("\n"); 
		query.append(",    A.DEL_CD" ).append("\n"); 
		query.append(",    A.MDT_ITM_RMK" ).append("\n"); 
		query.append(",    A.CRE_USR_ID" ).append("\n"); 
		query.append(",    A.CRE_DT" ).append("\n"); 
		query.append(",    A.UPD_USR_ID" ).append("\n"); 
		query.append(",    TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",    '' ITM_CD_POB" ).append("\n"); 
		query.append(",    'P/O No.(by BKG)' ITM_NM_POB" ).append("\n"); 
		query.append(",    '' ITM_CD_POC" ).append("\n"); 
		query.append(",    'P/O No.(by CNTR)' ITM_NM_POC" ).append("\n"); 
		query.append(",    '' ITM_CD_POM" ).append("\n"); 
		query.append(",    'P/O No.(by Item)' ITM_NM_POM" ).append("\n"); 
		query.append(",    '' ITM_CD_INV" ).append("\n"); 
		query.append(",    'Invoice No.' ITM_NM_INV" ).append("\n"); 
		query.append(",    '' ITM_CD_DEP" ).append("\n"); 
		query.append(",    'Department No.' ITM_NM_DEP" ).append("\n"); 
		query.append(",    '' ITM_CD_LC" ).append("\n"); 
		query.append(",    'L/C No.' ITM_NM_LC" ).append("\n"); 
		query.append(",    '' ITM_CD_SHP" ).append("\n"); 
		query.append(",    'Ship ID' ITM_NM_SHP" ).append("\n"); 
		query.append(",    '' ITM_CD_PAT" ).append("\n"); 
		query.append(",    'Part No.' ITM_NM_PAT" ).append("\n"); 
		query.append(",    '' ITM_CD_INC" ).append("\n"); 
		query.append(",    'Incoterms' ITM_NM_INC" ).append("\n"); 
		query.append(",    BKG_JOIN_FNC(CURSOR(SELECT BKG_MDT_ITM_CD  FROM BKG_MDT_ITM_DTL WHERE MDT_ITM_SEQ = A.MDT_ITM_SEQ)) AS BKG_MDT_ITM_CD" ).append("\n"); 
		query.append(",	 MDT_CUST_TP_CD||CUST_CNT_CD||CUST_SEQ AS FCUST" ).append("\n"); 
		query.append(",	(SELECT" ).append("\n"); 
		query.append("TO_CHAR(max(MN.EXP_DT), 'YYYY-MM-DD') AS TO_DT" ).append("\n"); 
		query.append("FROM   PRI_SP_HDR HD," ).append("\n"); 
		query.append("PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    HD.SC_NO =  A.SC_NO" ).append("\n"); 
		query.append("AND    HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    PROP_STS_CD ='F' ) SC_EXP_DT" ).append("\n"); 
		query.append(",	(SELECT" ).append("\n"); 
		query.append("TO_CHAR(max(MN.EXP_DT), 'YYYY-MM-DD') TO_DT" ).append("\n"); 
		query.append("FROM   PRI_RP_HDR HD," ).append("\n"); 
		query.append("PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    HD.RFA_NO = A.RFA_NO" ).append("\n"); 
		query.append("AND    HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    PROP_STS_CD ='A' /*상수*/) RFA_EXP_DT" ).append("\n"); 
		query.append("FROM BKG_MDT_ITM A" ).append("\n"); 
		query.append("WHERE (@[cust_grp_id] IS NULL OR A.CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("AND   A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("AND   A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND   A.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND   A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}