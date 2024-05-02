/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateCfmQtaZeroStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateCfmQtaZeroStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation QTA가 반영되지 않은 오피스들에 대해서 [Allocation = QTA Setting]의 Load, Status 를  [업데이트] 합니다.
	  * 
	  * 2014.01.17 [CHM-201428548] Allocation = QTA Adjustment 화면 내 "SPC Alloc Apply" 버튼 로직 변경
	  * 2014.01.23 [] Loading/Contract 의 상태를 모두 변경한다.(Portion Linked를 끊키 위해)
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateCfmQtaZeroStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateCfmQtaZeroStatusUSQL").append("\n"); 
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
		query.append("UPDATE CSQ_CFM_QTA " ).append("\n"); 
		query.append("   SET LOD_QTY       = DECODE(OFC_VW_CD, 'L', 0, 'C', LOD_QTY)" ).append("\n"); 
		query.append("      ,CSQ_CNG_TP_CD = DECODE(OFC_VW_CD, 'L', 'A', 'C', 'M')" ).append("\n"); 
		query.append("      ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT        = SYSDATE " ).append("\n"); 
		query.append(" WHERE BSE_YR                     = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("   AND CSQ_CNG_TP_CD              <> 'A'" ).append("\n"); 
		query.append("   AND TRD_CD                     = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD                   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD                     = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD                     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO                 = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD                 = @[skd_dir_cd]" ).append("\n"); 

	}
}