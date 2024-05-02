/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.09.30 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Match-back by Vessel
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel02RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel02RSQL").append("\n"); 
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
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD val01,								/* i_vsl_cd			*/" ).append("\n"); 
		query.append("SKD_VOY_NO val02,							/* i_skd_voy_no		*/" ).append("\n"); 
		query.append("SKD_DIR_CD val03,							/* i_skd_dir_cd		*/" ).append("\n"); 
		query.append("VPS_PORT_CD val04,						/* i_vps_port_cd	*/" ).append("\n"); 
		query.append("CLPT_IND_SEQ val05,						/* i_clpt_ind_seq	*/" ).append("\n"); 
		query.append("CLPT_SEQ val06,							/* i_clpt_seq		*/" ).append("\n"); 
		query.append("(SELECT PLN_YR||PLN_WK FROM EQR_WK_PRD WHERE TO_CHAR(VPS_ETD_DT, 'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT) val07,		/* i_vps_etd_dt		*/" ).append("\n"); 
		query.append("TO_CHAR(VPS_ETD_DT, 'YYYYMMDD') val08,	/* i_vps_etd_dt_1	*/" ).append("\n"); 
		query.append("FROM_RGN val09,							/* i_from_rgn		*/" ).append("\n"); 
		query.append("TO_RGN val10								/* i_to_rgn			*/" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VPS1.VSL_CD,		VPS1.SKD_VOY_NO,		VPS1.SKD_DIR_CD," ).append("\n"); 
		query.append("VPS1.VPS_PORT_CD,	VPS1.CLPT_IND_SEQ," ).append("\n"); 
		query.append("VPS1.CLPT_SEQ,		VPS1.VPS_ETD_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD)													FROM_RGN," ).append("\n"); 
		query.append("SUBSTR(MIN(LPAD(VPS2.CLPT_SEQ, 4)||DECODE(SCNT2.CONTI_CD, 'F', 'E', SCNT2.CONTI_CD)), 5, 1)			TO_RGN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS1,	MDM_COUNTRY CNT1,	MDM_SUBCONTINENT SCNT1," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS2,	MDM_COUNTRY CNT2,	MDM_SUBCONTINENT SCNT2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	NVL(VPS1.VPS_PORT_CD,		' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("AND		NVL(VPS1.TURN_PORT_IND_CD,	' ') NOT IN ('D', 'F', 'V')" ).append("\n"); 
		query.append("AND		NVL(VPS1.SKD_CNG_STS_CD,	' ') <> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		CNT1.CNT_CD				= SUBSTR(VPS1.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("AND		CNT1.SCONTI_CD			= SCNT1.SCONTI_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		VPS1.VSL_CD				= VPS.VSL_CD" ).append("\n"); 
		query.append("AND		VPS1.SKD_VOY_NO			= VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("AND		VPS1.SKD_DIR_CD			= VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		VPS2.VSL_CD				= VPS1.VSL_CD" ).append("\n"); 
		query.append("AND		VPS2.SKD_VOY_NO			= VPS1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		VPS2.SKD_DIR_CD			= VPS1.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		VPS2.CLPT_SEQ			> VPS1.CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		NVL(VPS2.VPS_PORT_CD,		' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("AND		NVL(VPS2.SKD_CNG_STS_CD,	' ') <> 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		CNT2.CNT_CD				= SUBSTR(VPS2.VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("AND		CNT2.SCONTI_CD			= SCNT2.SCONTI_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		VPS.SLAN_CD				= @[trade]" ).append("\n"); 
		query.append("AND		VPS.VSL_CD				= @[lane]" ).append("\n"); 
		query.append("AND		VPS.SKD_VOY_NO			= @[vvd]" ).append("\n"); 
		query.append("AND		VPS.SKD_DIR_CD			= @[company]" ).append("\n"); 
		query.append("AND		VPS.CLPT_SEQ			= 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD) = @[todate]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("VPS1.VSL_CD,		VPS1.SKD_VOY_NO,	VPS1.SKD_DIR_CD," ).append("\n"); 
		query.append("VPS1.VPS_PORT_CD,	VPS1.CLPT_IND_SEQ," ).append("\n"); 
		query.append("VPS1.CLPT_SEQ,		VPS1.VPS_ETD_DT," ).append("\n"); 
		query.append("DECODE(SCNT1.CONTI_CD, 'F', 'E', SCNT1.CONTI_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	( FROM_RGN = @[todate] AND TO_RGN = @[fromdate] )" ).append("\n"); 

	}
}