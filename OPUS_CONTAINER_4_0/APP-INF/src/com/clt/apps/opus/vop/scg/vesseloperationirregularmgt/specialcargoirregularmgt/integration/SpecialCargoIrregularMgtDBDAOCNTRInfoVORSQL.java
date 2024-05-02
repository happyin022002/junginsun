/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOCNTRInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.03.08 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOCNTRInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 정보 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOCNTRInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOCNTRInfoVORSQL").append("\n"); 
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
		query.append("BC.BKG_NO" ).append("\n"); 
		query.append(",	BC.CNTR_NO" ).append("\n"); 
		query.append(",	BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'Y')" ).append("\n"); 
		query.append(",   'DG' SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CG.CNTR_CGO_SEQ CGO_SEQ" ).append("\n"); 
		query.append(",	CG.IMDG_UN_NO" ).append("\n"); 
		query.append(",	CG.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	CG.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",   UN.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	CG.PRP_SHP_NM" ).append("\n"); 
		query.append("#elseif (${awk_cgo_flg} == 'Y')" ).append("\n"); 
		query.append(",   'AK' SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CG.AWK_CGO_SEQ CAGO_SEQ" ).append("\n"); 
		query.append(",	CG.GRS_WGT AWK_CGO_GRS_WGT" ).append("\n"); 
		query.append(",	CG.NET_WGT AWK_CGO_NET_WGT" ).append("\n"); 
		query.append(",	CG.TTL_DIM_LEN" ).append("\n"); 
		query.append(",	CG.TTL_DIM_WDT" ).append("\n"); 
		query.append(",	CG.TTL_DIM_HGT" ).append("\n"); 
		query.append(",	MC.CMDT_NM CMDT_DESC" ).append("\n"); 
		query.append("#elseif (${rc_flg} == 'Y')" ).append("\n"); 
		query.append(",   'RF' SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CG.RC_SEQ CGO_SEQ" ).append("\n"); 
		query.append(",	CG.GRS_WGT AWK_CGO_GRS_WGT" ).append("\n"); 
		query.append(",	CG.NET_WGT AWK_CGO_NET_WGT" ).append("\n"); 
		query.append(",   CG.CMDT_DESC" ).append("\n"); 
		query.append("#elseif (${bb_cgo_flg} == 'Y')" ).append("\n"); 
		query.append(",   'BB' SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CG.BB_CGO_SEQ CGO_SEQ" ).append("\n"); 
		query.append(",	CG.GRS_WGT AWK_CGO_GRS_WGT" ).append("\n"); 
		query.append(",	CG.NET_WGT AWK_CGO_NET_WGT" ).append("\n"); 
		query.append(",	CG.DIM_LEN" ).append("\n"); 
		query.append(",	CG.DIM_WDT" ).append("\n"); 
		query.append(",	CG.DIM_H" ).append("\n"); 
		query.append(",	MC.CMDT_NM CMDT_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", BP.BAY||BP.ROWW||BP.TIER CELL_PSN_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'Y')" ).append("\n"); 
		query.append(",	BKG_DG_CGO CG" ).append("\n"); 
		query.append(",   SCG_IMDG_UN_NO UN" ).append("\n"); 
		query.append("#elseif (${awk_cgo_flg} == 'Y')" ).append("\n"); 
		query.append(",	BKG_AWK_CGO CG" ).append("\n"); 
		query.append(",   MDM_COMMODITY MC" ).append("\n"); 
		query.append("#elseif (${rc_flg} == 'Y')" ).append("\n"); 
		query.append(",	BKG_RF_CGO CG" ).append("\n"); 
		query.append("#elseif (${bb_cgo_flg} == 'Y')" ).append("\n"); 
		query.append(",	BKG_BB_CGO CG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", BAY_PLAN      BP" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'Y' || ${awk_cgo_flg} == 'Y' || ${rc_flg} == 'Y' || ${bb_cgo_flg} == 'Y')" ).append("\n"); 
		query.append("AND BC.BKG_NO = CG.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = CG.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} == 'Y' || ${bb_cgo_flg} == 'Y')" ).append("\n"); 
		query.append("AND CG.CMDT_CD = MC.CMDT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dcgo_flg} == 'Y')" ).append("\n"); 
		query.append("AND CG.IMDG_UN_NO = UN.IMDG_UN_NO" ).append("\n"); 
		query.append("AND CG.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BC.CNTR_NO      = BP.ID(+)" ).append("\n"); 
		query.append("AND BP.PLAN_TYPE(+) = 'F'" ).append("\n"); 
		query.append("AND BP.PORT_CD(+)   = @[pol_yd_cd]" ).append("\n"); 
		query.append("AND BP.VSL_CD(+)    = @[vsl_cd]" ).append("\n"); 
		query.append("AND BP.VOY_NO(+)    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND BP.DIR_CD(+)    = @[skd_dir_cd]" ).append("\n"); 

	}
}