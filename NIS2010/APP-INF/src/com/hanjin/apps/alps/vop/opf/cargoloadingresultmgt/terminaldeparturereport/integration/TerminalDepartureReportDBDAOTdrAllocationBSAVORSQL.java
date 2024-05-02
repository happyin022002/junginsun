/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrAllocationBSAVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.09 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrAllocationBSAVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrAllocationBSAVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrAllocationBSAVORSQL").append("\n"); 
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
		query.append("SELECT 	X.OPR_CD," ).append("\n"); 
		query.append("X.BSA_SLOT," ).append("\n"); 
		query.append("X.RELEASE_SLOT," ).append("\n"); 
		query.append("X.SWAP_SLOT," ).append("\n"); 
		query.append("X.TTL_ALLOC," ).append("\n"); 
		query.append("X.BSA_WGT," ).append("\n"); 
		query.append("X.RELEASE_WGT," ).append("\n"); 
		query.append("X.SWAP_WGT," ).append("\n"); 
		query.append("X.BSA_TYPE," ).append("\n"); 
		query.append("X.TTL_WEIGHT," ).append("\n"); 
		query.append("Y.TEU," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("X.RATIO_TYPE" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT C.OPR_CD," ).append("\n"); 
		query.append("C.BSA_SLOT," ).append("\n"); 
		query.append("C.RELEASE_SLOT," ).append("\n"); 
		query.append("C.SWAP_SLOT," ).append("\n"); 
		query.append("NVL(C.BSA_SLOT, 0)+" ).append("\n"); 
		query.append("NVL(C.RELEASE_SLOT, 0)+" ).append("\n"); 
		query.append("NVL(C.SWAP_SLOT, 0)  AS TTL_ALLOC," ).append("\n"); 
		query.append("C.BSA_WGT," ).append("\n"); 
		query.append("C.RELEASE_WGT," ).append("\n"); 
		query.append("C.SWAP_WGT," ).append("\n"); 
		query.append("NVL(C.BSA_WGT, 0) +" ).append("\n"); 
		query.append("NVL(C.RELEASE_WGT, 0) +" ).append("\n"); 
		query.append("NVL(C.SWAP_WGT, 0)   AS  TTL_WEIGHT," ).append("\n"); 
		query.append("C.BSA_TYPE," ).append("\n"); 
		query.append("C.RATIO_TYPE" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_ALLOCATION C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  	   = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO    = @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 		   = @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD        = H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO    = H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD    = H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD   = H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ  = H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO        = C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD        = C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD       = C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND      = C.CALL_IND" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(   SELECT A.CRR_CD," ).append("\n"); 
		query.append("SUM(DECODE(A.BSA_OP_JB_CD,'008',DECODE(B.PORT_BSA_CAPA,NULL,A.CRR_BSA_CAPA,0,A.CRR_BSA_CAPA,B.PORT_BSA_CAPA))) AS TEU" ).append("\n"); 
		query.append("FROM   BSA_VVD_OTR_CRR A," ).append("\n"); 
		query.append("( SELECT B.RLANE_CD, B.DIR_CD, B.TRD_CD, B.CRR_CD, B.BSA_OP_JB_CD," ).append("\n"); 
		query.append("SUBSTR(MAX('0'||B.BSA_SEQ||B.PORT_BSA_CAPA),3) PORT_BSA_CAPA" ).append("\n"); 
		query.append("FROM   BSA_SLT_CHTR_PORT_DWN B" ).append("\n"); 
		query.append("WHERE  PORT_CD(+) = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("AND    RLANE_CD = ( SELECT D.RLANE_CD" ).append("\n"); 
		query.append("FROM   MDM_REV_LANE R, MDM_DTL_REV_LANE D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  D.RLANE_CD    = R.RLANE_CD" ).append("\n"); 
		query.append("AND    V.VSL_CD      = @[vsl_cd]   --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  = @[voy_no]   --:skd_voy_no" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  = @[dir_cd]   --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD = @[port_cd]  --:port_cd" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    R.VSL_SLAN_CD = V.SLAN_CD" ).append("\n"); 
		query.append("AND    ( D.FM_CONTI_CD, D.TO_CONTI_CD ) IN (" ).append("\n"); 
		query.append("SELECT CONTI_CD, NVL(LEAD_CONTI_CD, CONTI_CD)" ).append("\n"); 
		query.append("FROM   ( SELECT V.CLPT_SEQ, V.VPS_PORT_CD, L.CONTI_CD," ).append("\n"); 
		query.append("LEAD(CONTI_CD) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD ORDER BY V.CLPT_SEQ) LEAD_CONTI_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE  V.VSL_CD      = @[vsl_cd]       --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  = @[voy_no]       --:skd_voy_no" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  = @[dir_cd]       --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD = @[port_cd]      --:port_cd" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD = L.LOC_CD )" ).append("\n"); 
		query.append("WHERE  CONTI_CD = 'A'" ).append("\n"); 
		query.append("AND    CONTI_CD <> NVL(LEAD_CONTI_CD,'X') )" ).append("\n"); 
		query.append("AND    D.VSL_SLAN_DIR_CD = NVL('W',D.VSL_SLAN_DIR_CD)  --:skd_dir_cd" ).append("\n"); 
		query.append("AND    D.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("AND    ROWNUM = 1 )" ).append("\n"); 
		query.append("AND    DIR_CD       = @[dir_cd]                                                  --:skd_dir_cd" ).append("\n"); 
		query.append("AND    BSA_OP_JB_CD IN ('008')" ).append("\n"); 
		query.append("GROUP BY RLANE_CD, DIR_CD, TRD_CD, CRR_CD, BSA_OP_JB_CD ) B" ).append("\n"); 
		query.append("WHERE  A.RLANE_CD     = B.RLANE_CD(+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD   = B.DIR_CD(+)" ).append("\n"); 
		query.append("AND    A.TRD_CD       = B.TRD_CD(+)" ).append("\n"); 
		query.append("AND    A.CRR_CD       = B.CRR_CD(+)" ).append("\n"); 
		query.append("AND    A.BSA_OP_JB_CD = B.BSA_OP_JB_CD(+)" ).append("\n"); 
		query.append("AND    A.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("AND    A.BSA_OP_JB_CD IN ('008')" ).append("\n"); 
		query.append("AND    ( A.CRR_BSA_CAPA > 0 OR B.PORT_BSA_CAPA > 0 )" ).append("\n"); 
		query.append("GROUP BY A.CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.OPR_CD = Y.CRR_CD(+)" ).append("\n"); 
		query.append("ORDER BY X.OPR_CD" ).append("\n"); 

	}
}