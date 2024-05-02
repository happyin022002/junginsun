/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.08 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IRG가 존재여부 체크
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL").append("\n"); 
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
		query.append("SELECT REGEXP_REPLACE(TRS_GET_COP_BND_SO_STR_FNC(SCE.COP_NO, SCE.V_BND_CD, SCE.V_COST_ACT_GRP_SEQ, SCE.V_TRSP_CRR_MOD_CD, SCE.V_FM_NOD_CD, SCE.V_VIA_NOD_CD, SCE.V_DOR_NOD_CD, SCE.V_TO_NOD_CD),'-...-','-') SO" ).append("\n"); 
		query.append(",PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ) PRD" ).append("\n"); 
		query.append("FROM  PRD_INLND_ROUT_MST M1" ).append("\n"); 
		query.append(",(SELECT COP_NO" ).append("\n"); 
		query.append(",POR_NOD_CD" ).append("\n"); 
		query.append(",POL_NOD_CD" ).append("\n"); 
		query.append(",POD_NOD_CD" ).append("\n"); 
		query.append(",DEL_NOD_CD" ).append("\n"); 
		query.append(",@[v_bnd_cd] AS V_BND_CD" ).append("\n"); 
		query.append(",@[v_cost_act_grp_seq] AS V_COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",@[v_trsp_crr_mod_cd] AS  V_TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",@[v_fm_nod_cd]  AS V_FM_NOD_CD" ).append("\n"); 
		query.append(",@[v_via_nod_cd] AS V_VIA_NOD_CD" ).append("\n"); 
		query.append(",@[v_dor_nod_cd] AS V_DOR_NOD_CD" ).append("\n"); 
		query.append(",@[v_to_nod_cd]  AS V_TO_NOD_CD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE COP_NO = @[v_cop_no]) SCE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M1.ROUT_ORG_NOD_CD LIKE DECODE(SCE.V_BND_CD,'O',SUBSTR(SCE.POR_NOD_CD,1,5)||'%',SCE.POD_NOD_CD)" ).append("\n"); 
		query.append("AND M1.ROUT_DEST_NOD_CD LIKE DECODE(SCE.V_BND_CD,'I',SUBSTR(SCE.DEL_NOD_CD,1,5)||'%',SCE.POL_NOD_CD)" ).append("\n"); 
		query.append("AND NVL(M1.PCTL_IO_BND_CD,SCE.V_BND_CD) IN (SCE.V_BND_CD ,'B')" ).append("\n"); 
		query.append("AND NVL(M1.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ) LIKE REGEXP_REPLACE(TRS_GET_COP_BND_SO_STR_FNC(SCE.COP_NO, SCE.V_BND_CD, SCE.V_COST_ACT_GRP_SEQ, SCE.V_TRSP_CRR_MOD_CD, SCE.V_FM_NOD_CD, SCE.V_VIA_NOD_CD, SCE.V_DOR_NOD_CD, SCE.V_TO_NOD_CD),'-...-','-')||'%'" ).append("\n"); 

	}
}