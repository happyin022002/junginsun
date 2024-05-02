/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchICtoVADsendValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.03.16 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchICtoVADsendValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchICtoVADsendValidation
	  * </pre>
	  */
	public Edi315SendDBDAOSearchICtoVADsendValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_del_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_group_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchICtoVADsendValidationRSQL").append("\n"); 
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
		query.append("SELECT COP_DTL_SEQ, C.ACT_DT, NOD_CD, DECODE(pod.act_dt, '0', c.estm_dt, pod.act_dt) estm_dt" ).append("\n"); 
		query.append("FROM BKG_booking" ).append("\n"); 
		query.append(",(SELECT COP_NO" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND STND_EDI_STS_CD = 'UVT'" ).append("\n"); 
		query.append("AND VPS_PORT_CD = @[chk_port_cd]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(",(SELECT COP_NO ,a.cop_dtl_seq ,ACT_DT, NOD_CD , vsl_cd   ,skd_voy_no  ,skd_dir_cd, TO_CHAR(estm_dt, 'YYYYMMDDHH24MI') estm_dt" ).append("\n"); 
		query.append("FROM SCE_COP_DTL a, sce_act_act_mapg b" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND a.act_cd          = b.act_cd" ).append("\n"); 
		query.append("AND STND_EDI_STS_CD = 'VAD'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append(",(SELECT COUNT(*) VSL_CNT, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append(")CNT" ).append("\n"); 
		query.append(",(SELECT SUM(act_dt) act_dt" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT act_dt" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT rownum rn, to_char(act_dt, 'YYYYMMDDHH24MI') act_dt" ).append("\n"); 
		query.append("FROM sce_edi_snd_rslt" ).append("\n"); 
		query.append("WHERE (bkg_no, cntr_no ) = ( SELECT bkg_no, cntr_no FROM sce_cop_hdr WHERE cop_no = @[cop_no] )" ).append("\n"); 
		query.append("AND edi_sts_cd = 'VAD'" ).append("\n"); 
		query.append("AND edi_grp_cd = @[edi_group_cd]" ).append("\n"); 
		query.append("ORDER BY cre_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE rn = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '0' act_dt FROM dual" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")pod" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and pod_cd = @[e_pod_loc]" ).append("\n"); 
		query.append("AND DEL_CD = @[e_del_loc]" ).append("\n"); 
		query.append("AND CNT.VSL_CNT = 1" ).append("\n"); 

	}
}