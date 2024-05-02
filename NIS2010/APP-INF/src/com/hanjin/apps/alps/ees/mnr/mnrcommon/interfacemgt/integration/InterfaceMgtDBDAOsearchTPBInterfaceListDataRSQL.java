/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTPBInterfaceListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * [] rpr_rqst_seq 와 rpr_rqst_ver_no 조건 추가 
	  * 2013.02.15 조경완 [CHM-201322897-01] ALPS-CNTR MNR-Repair -Estimate Creation 화면 상에서 TPB Interface 에러 건 수정 요청
	  *  - rqst_seq 와 ver_no 를 조건에 추가 
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
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(MRH XPKMNR_RPR_RQST_HDR)*/" ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_GET_ACCT_CD_FNC(MRH.EQ_KND_CD, 'MRDRDR', MRH.EQ_TPSZ_CD, MRH.RPR_OFFH_FLG) ACCT_CD," ).append("\n"); 
		query.append("'MRDRRC' COST_CODE," ).append("\n"); 
		query.append("MRH.VNDR_SEQ SRC_VNDR_SEQ," ).append("\n"); 
		query.append("MRH.CURR_CD CURR_CD," ).append("\n"); 
		query.append("MRH.CURR_CD  IF_CURR_CD," ).append("\n"); 
		query.append("MRH.N3PTY_BIL_TTL_AMT  IF_AMT," ).append("\n"); 
		query.append("MRH.RQST_REF_NO N3PTY_SRC_NO," ).append("\n"); 
		query.append("MRH.RPR_RQST_SEQ ESTM_SEQ_NO," ).append("\n"); 
		query.append("MRH.RPR_RQST_VER_NO ESTM_DTL_SEQ_NO," ).append("\n"); 
		query.append("MRH.RPR_RQST_VER_NO ESTM_RVIS_NO," ).append("\n"); 
		query.append("MRH.EQ_KND_CD," ).append("\n"); 
		query.append("MRH.RQST_EQ_NO EQ_NO," ).append("\n"); 
		query.append("MRH.EQ_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("MRH.COST_OFC_CD IF_OFC_CD" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR MRH" ).append("\n"); 
		query.append("WHERE MRH.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND MRH.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND MRH.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}