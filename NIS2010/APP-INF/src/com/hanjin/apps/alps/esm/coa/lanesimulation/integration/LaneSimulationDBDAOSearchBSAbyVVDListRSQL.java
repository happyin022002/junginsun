/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchBSAbyVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.03 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchBSAbyVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL 과 BSA I/F
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchBSAbyVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("#set( $bsa_op_jb_cd = ['001', '002','003'",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchBSAbyVVDListRSQL").append("\n"); 
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
		query.append("#set( $bsa_op_jb_cd = ['001', '002','003'] )" ).append("\n"); 
		query.append("#set( $num = ['01', '02','03','04','05'] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B1.VSL_CD" ).append("\n"); 
		query.append(",B1.CHK_FLAG" ).append("\n"); 
		query.append(",B1.DIR_CD  SKD_DIR_CD" ).append("\n"); 
		query.append(",B1.VSL_OSHP_CD" ).append("\n"); 
		query.append(",B1.VOP_CD" ).append("\n"); 
		query.append(",B1.VSL_CLSS" ).append("\n"); 
		query.append(",B1.BSA_CAPA" ).append("\n"); 
		query.append(",B1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",B1.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("#foreach( $jb_index in $bsa_op_jb_cd )" ).append("\n"); 
		query.append("#foreach( $n_index in $num )" ).append("\n"); 
		query.append(",MAX(DECODE(B1.BSA_OP_JB_CD, '$jb_index', DECODE(B1.CNT, TO_NUMBER($n_index), NVL(B1.CRR_BSA_CAPA,0)))) BSA$jb_index$n_index" ).append("\n"); 
		query.append(",MAX(DECODE(B1.BSA_OP_JB_CD, '$jb_index', DECODE(B1.CNT, TO_NUMBER($n_index), DECODE(NVL(B1.CRR_BSA_CAPA,0),0,0,B1.CRR_PERF_AMT/B1.CRR_BSA_CAPA)))) AMT$jb_index$n_index" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",B1.VSL_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT    A1.COST_YRMON" ).append("\n"); 
		query.append("#if (${r_vsl} != '')" ).append("\n"); 
		query.append(",DECODE(A1.VSL_CD${r_vsl}) CHK_FLAG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'N' AS CHK_FLAG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",DECODE(NVL(A5.VSL_FLG,'*'),'*','N',A5.VSL_FLG)  VSL_FLG" ).append("\n"); 
		query.append(",A1.VSL_CD" ).append("\n"); 
		query.append(",A1.SKD_VOY_NO" ).append("\n"); 
		query.append(",A1.DIR_CD" ).append("\n"); 
		query.append(",NVL(A5.VSL_OSHP_CD,'OTH') VSL_OSHP_CD" ).append("\n"); 
		query.append(",NVL(A5.VOP_CD,'OTH') VOP_CD" ).append("\n"); 
		query.append(",NVL(A5.VSL_CLSS,'') VSL_CLSS" ).append("\n"); 
		query.append(",A3.BSA_CAPA" ).append("\n"); 
		query.append(",NVL(A5.VSL_CLSS_CAPA,'') VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",A3.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append(",A4.BSA_OP_JB_CD BSA_OP_JB_CD1" ).append("\n"); 
		query.append(",DECODE(A4.BSA_OP_JB_CD, '004','002','005','003','001') BSA_OP_JB_CD" ).append("\n"); 
		query.append(",A4.CRR_CD" ).append("\n"); 
		query.append(",A4.CRR_BSA_CAPA" ).append("\n"); 
		query.append(",A4.CRR_PERF_AMT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD, DECODE(A4.BSA_OP_JB_CD, '004','002','005','003','001')" ).append("\n"); 
		query.append("ORDER BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD,DECODE(A4.BSA_OP_JB_CD, '004','002','005','003','001'),A4.CRR_BSA_CAPA DESC,A4.CRR_CD) CNT" ).append("\n"); 
		query.append("FROM COA_MON_VVD A1" ).append("\n"); 
		query.append(",COA_LANE_RGST A2" ).append("\n"); 
		query.append(",BSA_VVD_MST A3" ).append("\n"); 
		query.append(",BSA_VVD_CRR_PERF A4" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT '' VSL_FLG" ).append("\n"); 
		query.append(",X.VSL_CD" ).append("\n"); 
		query.append(",X.VSL_OSHP_CD" ).append("\n"); 
		query.append(",X.VOP_CD" ).append("\n"); 
		query.append(",DECODE(Y.SUB_TRD_CAPA,0, X.STND_LDB_CAPA,Y.SUB_TRD_CAPA) VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",X.VSL_CLSS_CAPA AS VSL_CLSS" ).append("\n"); 
		query.append(",X.DELT_FLG" ).append("\n"); 
		query.append("FROM COA_VSL_RGST X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.VSL_CD, MAX(B.SUB_TRD_CAPA) SUB_TRD_CAPA,B.VSL_SEQ" ).append("\n"); 
		query.append("FROM MDM_SUB_TRD A, COA_VSL_SUB_TRD_CAPA B" ).append("\n"); 
		query.append("WHERE A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("AND A.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("GROUP BY B.VSL_CD, B.VSL_SEQ" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.VSL_CD             = Y.VSL_CD(+)" ).append("\n"); 
		query.append("AND X.VSL_SEQ            = Y.VSL_SEQ(+)" ).append("\n"); 
		query.append("AND X.VSL_TP_CD          = 'C'" ).append("\n"); 
		query.append("AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND LST_FLG = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y' VSL_FLG, VSL_CD, VSL_OSHP_CD, VOP_CD, STND_LDB_CAPA VSL_CLSS_CAPA, VSL_CLSS_CAPA AS VSL_CLSS, 'N' DELT_FLG" ).append("\n"); 
		query.append("FROM COA_SIM_VSL_RGST" ).append("\n"); 
		query.append(") A5" ).append("\n"); 
		query.append("WHERE A1.TRD_CD     = A3.TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A3.RLANE_CD" ).append("\n"); 
		query.append("AND A1.IOC_CD     = A3.IOC_CD" ).append("\n"); 
		query.append("AND A1.VSL_CD     = A3.VSL_CD" ).append("\n"); 
		query.append("AND A1.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A1.DIR_CD     = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("AND A1.IOC_CD     = A2.IOC_CD" ).append("\n"); 
		query.append("AND A1.VSL_CD     = A5.VSL_CD" ).append("\n"); 
		query.append("AND NVL(A5.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("AND NVL(A1.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("AND NVL(A2.DELT_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("AND A3.TRD_CD     = A4.TRD_CD(+)" ).append("\n"); 
		query.append("AND A3.RLANE_CD   = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("AND A3.VSL_CD     = A4.VSL_CD(+)" ).append("\n"); 
		query.append("AND A3.SKD_VOY_NO = A4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A3.SKD_DIR_CD = A4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A4.CRR_CD(+)  != 'HJS'" ).append("\n"); 
		query.append("AND A1.SLS_YRMON  LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("AND A1.COST_WK    BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND A1.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("AND A1.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ioc_cd} != '')" ).append("\n"); 
		query.append("AND A1.IOC_CD     = @[ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl} == 0)" ).append("\n"); 
		query.append("AND A1.VSL_CD    IN (${vsl})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD,BSA_OP_JB_CD, CNT" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append("WHERE B1.CNT <= 5" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("B1.VSL_CD" ).append("\n"); 
		query.append(",B1.CHK_FLAG" ).append("\n"); 
		query.append(",B1.VSL_FLG" ).append("\n"); 
		query.append(",B1.DIR_CD" ).append("\n"); 
		query.append(",B1.VSL_OSHP_CD" ).append("\n"); 
		query.append(",B1.VOP_CD" ).append("\n"); 
		query.append(",B1.VSL_CLSS" ).append("\n"); 
		query.append(",B1.BSA_CAPA" ).append("\n"); 
		query.append(",B1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",B1.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("ORDER BY B1.VSL_CD, B1.DIR_CD" ).append("\n"); 

	}
}