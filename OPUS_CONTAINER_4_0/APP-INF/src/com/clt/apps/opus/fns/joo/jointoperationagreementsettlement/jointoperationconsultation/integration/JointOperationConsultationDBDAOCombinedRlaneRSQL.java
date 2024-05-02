/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCombinedRlaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCombinedRlaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건에 맞는 RLANE 과 CMB_CFM_FLG를 조회한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCombinedRlaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCombinedRlaneRSQL").append("\n"); 
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
		query.append("       A.RLANE_CD" ).append("\n"); 
		query.append("      ,NVL(A.CMB_CFM_FLG,'N') AS CMB_CFM_FLG" ).append("\n"); 
		query.append("      ,C.JO_CRR_AUTH_CD AS STL_DUP_FLG -- TABLE VO이므로 임의로 쓰자 ㅡ,.ㅡ" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("       JOO_STL_CMB_DTL B," ).append("\n"); 
		query.append("       JOO_CRR_AUTH    C" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD   = C.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("AND    C.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    C.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("--2010.01.28 WRITE권한만 조회되게 한다 BY 권상준 수석" ).append("\n"); 
		query.append("AND    C.JO_CRR_AUTH_CD = 'W'" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND    A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stl_cmb_seq} != '')" ).append("\n"); 
		query.append("AND    B.STL_CMB_SEQ = @[stl_cmb_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    NVL(A.CMB_CFM_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP  BY" ).append("\n"); 
		query.append("       A.RLANE_CD" ).append("\n"); 
		query.append("      ,NVL(A.CMB_CFM_FLG,'N')" ).append("\n"); 
		query.append("      ,C.JO_CRR_AUTH_CD" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 

	}
}