/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTPBInterfaceListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchTPBInterfaceListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTPBInterfaceListData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchTPBInterfaceListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchTPBInterfaceListDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(MRH XPKMNR_RPR_RQST_HDR)*/ " ).append("\n"); 
		query.append("      		   MNR_COMMON_PKG.MNR_GET_ACCT_CD_FNC(MRH.EQ_KND_CD, 'MRDRRC', MRH.EQ_TPSZ_CD, MRH.RPR_OFFH_FLG, DECODE(MRH.RPR_OFFH_FLG, 'Y', 'OF', 'NR')) ACCT_CD," ).append("\n"); 
		query.append("			   'MRDRRC' COST_CODE," ).append("\n"); 
		query.append("			   MRH.VNDR_SEQ SRC_VNDR_SEQ," ).append("\n"); 
		query.append("			   MRH.CURR_CD CURR_CD," ).append("\n"); 
		query.append("			   MRH.CURR_CD  IF_CURR_CD," ).append("\n"); 
		query.append("			   MRH.N3PTY_BIL_TTL_AMT  IF_AMT," ).append("\n"); 
		query.append("			   MRH.RQST_REF_NO N3PTY_SRC_NO," ).append("\n"); 
		query.append("			   MRH.RPR_RQST_SEQ ESTM_SEQ_NO," ).append("\n"); 
		query.append("			   MRH.RPR_RQST_VER_NO ESTM_DTL_SEQ_NO," ).append("\n"); 
		query.append("			   MRH.RPR_RQST_VER_NO ESTM_RVIS_NO," ).append("\n"); 
		query.append("			   MRH.EQ_KND_CD," ).append("\n"); 
		query.append("			   MRH.RQST_EQ_NO EQ_NO," ).append("\n"); 
		query.append("			   MRH.EQ_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("               MRH.COST_OFC_CD IF_OFC_CD" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR MRH" ).append("\n"); 
		query.append("WHERE MRH.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}