/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOSearchActualSCETerminalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2011.03.10 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeYoonJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchActualSCETerminalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd, yard, turn vvd 등의 정보를 받아 이를 바탕으로 COP Replan 을 수행할 COP 를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchActualSCETerminalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchActualSCETerminalRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("A.COP_NO AS COP_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("COP_STS_CD," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("MST_COP_NO," ).append("\n"); 
		query.append("TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("POR_NOD_CD," ).append("\n"); 
		query.append("POL_NOD_CD," ).append("\n"); 
		query.append("POD_NOD_CD," ).append("\n"); 
		query.append("DEL_NOD_CD," ).append("\n"); 
		query.append("COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("IB_TRO_FLG," ).append("\n"); 
		query.append("OB_TRO_FLG," ).append("\n"); 
		query.append("UMCH_STS_CD," ).append("\n"); 
		query.append("PROV_CNTR_NO," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(CFM_APNT_DT, 'YYYYMMDDHH24MISS') AS CFM_APNT_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("SCE_COP_DTL B" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("AND B.VSL_CD IN (@[vsl_cd], @[turn_vsl_cd])" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO IN (@[skd_voy_no], @[turn_skd_voy_no])" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD IN (@[skd_dir_cd], @[turn_skd_dir_cd])" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("AND DECODE(B.CLPT_IND_SEQ, '', 1, B.CLPT_IND_SEQ) = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND B.ACT_CD IN ('FLVMLO'," ).append("\n"); 
		query.append("'FLWMLO'," ).append("\n"); 
		query.append("'FUVMUD'," ).append("\n"); 
		query.append("'FUWMUD'," ).append("\n"); 
		query.append("'FTVMLO'," ).append("\n"); 
		query.append("'FTWMLO'," ).append("\n"); 
		query.append("'FTVMUD'," ).append("\n"); 
		query.append("'FTWMUD')" ).append("\n"); 
		query.append("AND A.COP_STS_CD IN ('C'," ).append("\n"); 
		query.append("'T'," ).append("\n"); 
		query.append("'F')" ).append("\n"); 

	}
}