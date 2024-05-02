/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOAddFixedFlagInfoByPriCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOAddFixedFlagInfoByPriCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pri에서 Fixed Flag가 체크된 계약의 계약NO 정보 I/F 받는다.
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * </pre>
	  */
	public ConstraintMasterDBDAOAddFixedFlagInfoByPriCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOAddFixedFlagInfoByPriCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_LANE_CTRL_OPT_DTL" ).append("\n"); 
		query.append("           (  TRD_CD" ).append("\n"); 
		query.append("            , SUB_TRD_CD" ).append("\n"); 
		query.append("            , RLANE_CD" ).append("\n"); 
		query.append("            , DIR_CD" ).append("\n"); 
		query.append("            , ALOC_CTRL_TP_CD " ).append("\n"); 
		query.append("            , CTRL_LOC_ACCT_CD " ).append("\n"); 
		query.append("            , ALOC_CTRL_DTL_CD " ).append("\n"); 
		query.append("            , SC_NO " ).append("\n"); 
		query.append("            , RFA_NO " ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("            , CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("         A3.TRD_CD" ).append("\n"); 
		query.append("       , A3.SUB_TRD_CD" ).append("\n"); 
		query.append("       , A3.RLANE_CD" ).append("\n"); 
		query.append("       , A3.DIR_CD" ).append("\n"); 
		query.append("       , 'F' AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("       , A5.SC_NO AS CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("       , A5.SC_NO AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("       , '*' AS SC_NO" ).append("\n"); 
		query.append("       , '*' AS RFA_NO" ).append("\n"); 
		query.append("       , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("       , @[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("       , 'Y' AS CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN 			A1" ).append("\n"); 
		query.append("    ,PRI_SP_SCP_RT_CMDT_HDR A2" ).append("\n"); 
		query.append("    ,SPC_ALOC_LANE_CTRL_OPT A3" ).append("\n"); 
		query.append("    ,MDM_SVC_SCP_LANE       A4" ).append("\n"); 
		query.append("	,PRI_SP_HDR 			A5" ).append("\n"); 
		query.append("WHERE A1.PROP_NO            = A2.PROP_NO" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ             = A2.AMDT_SEQ" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD           = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND NVL(A2.FX_RT_FLG,'N')   = 'Y'" ).append("\n"); 
		query.append("AND A1.PROP_NO              = @[prop_no]" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ             = @[amdt_seq]" ).append("\n"); 
		query.append("AND SUBSTR(A3.RLANE_CD,1,3) = A4.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A4.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD           = A4.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A1.PROP_NO              = A5.PROP_NO" ).append("\n"); 
		query.append("--SPC_ALOC_LANE_CTRL_OPT_DTL 테이블에 없을때만 insert" ).append("\n"); 
		query.append(" AND NOT EXISTS (SELECT * " ).append("\n"); 
		query.append("                 FROM SPC_ALOC_LANE_CTRL_OPT_DTL C1" ).append("\n"); 
		query.append("                 WHERE C1.TRD_CD            = A3.TRD_CD" ).append("\n"); 
		query.append("                 AND   C1.SUB_TRD_CD        = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("                 AND   C1.RLANE_CD          = A3.RLANE_CD" ).append("\n"); 
		query.append("                 AND   C1.DIR_CD            = A3.DIR_CD" ).append("\n"); 
		query.append("                 AND   C1.ALOC_CTRL_TP_CD   = 'F'" ).append("\n"); 
		query.append("                 AND   C1.CTRL_LOC_ACCT_CD  = A5.SC_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}