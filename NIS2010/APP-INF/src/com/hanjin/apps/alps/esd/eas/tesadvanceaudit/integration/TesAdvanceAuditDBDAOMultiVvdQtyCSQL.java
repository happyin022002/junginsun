/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOMultiVvdQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.22 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOMultiVvdQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Quantity 등록 수정
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOMultiVvdQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_rc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hngr_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfs_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_bb_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOMultiVvdQtyCSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_TML_MRN_VVD_QTY K USING(" ).append("\n"); 
		query.append("	SELECT	  @[yd_cd] AS YD_CD" ).append("\n"); 
		query.append("			, @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("			, @[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("			, @[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("			, @[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append("			, @[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			, @[ts_flg] AS TS_FLG" ).append("\n"); 
		query.append("			, @[full_mty_cd] AS FULL_MTY_CD" ).append("\n"); 
		query.append("	FROM DUAL " ).append("\n"); 
		query.append("	) B" ).append("\n"); 
		query.append("	ON		( K.YD_CD		= B.YD_CD" ).append("\n"); 
		query.append("	AND		K.VSL_CD		= B.VSL_CD" ).append("\n"); 
		query.append("	AND		K.SKD_VOY_NO	= B.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND		K.SKD_DIR_CD	= B.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND		K.IO_BND_CD		= B.IO_BND_CD" ).append("\n"); 
		query.append("	AND		K.CNTR_TPSZ_CD	= B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	AND		K.TS_FLG		= B.TS_FLG" ).append("\n"); 
		query.append("	AND		K.FULL_MTY_CD	= B.FULL_MTY_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE" ).append("\n"); 
		query.append("	SET		  K.CNTR_TTL_QTY	= @[cntr_ttl_qty]" ).append("\n"); 
		query.append("			, K.DCGO_QTY		= @[dcgo_qty]" ).append("\n"); 
		query.append("			, K.RC_QTY			= @[rc_qty]" ).append("\n"); 
		query.append("			, K.DG_RC_QTY		= @[dg_rc_qty]" ).append("\n"); 
		query.append("			, K.AWK_CGO_QTY		= @[awk_cgo_qty]" ).append("\n"); 
		query.append("			, K.BB_CGO_QTY		= @[bb_cgo_qty]" ).append("\n"); 
		query.append("			, K.AWK_BB_CGO_QTY	= @[awk_bb_cgo_qty]" ).append("\n"); 
		query.append("			, K.HNGR_CGO_QTY	= @[hngr_cgo_qty]" ).append("\n"); 
		query.append("			, K.CFS_CGO_QTY		= @[cfs_cgo_qty]" ).append("\n"); 
		query.append("			, K.UPD_DT			= SYSDATE" ).append("\n"); 
		query.append("			, K.UPD_USR_ID		= 'Batch'" ).append("\n"); 
		query.append("	WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT(" ).append("\n"); 
		query.append("			  YD_CD" ).append("\n"); 
		query.append("			, VSL_CD" ).append("\n"); 
		query.append("			, SKD_VOY_NO" ).append("\n"); 
		query.append("			, SKD_DIR_CD" ).append("\n"); 
		query.append("			, IO_BND_CD" ).append("\n"); 
		query.append("			, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			, TS_FLG" ).append("\n"); 
		query.append("			, FULL_MTY_CD" ).append("\n"); 
		query.append("			, CNTR_TTL_QTY" ).append("\n"); 
		query.append("			, DCGO_QTY" ).append("\n"); 
		query.append("			, RC_QTY" ).append("\n"); 
		query.append("			, DG_RC_QTY" ).append("\n"); 
		query.append("			, AWK_CGO_QTY" ).append("\n"); 
		query.append("			, BB_CGO_QTY" ).append("\n"); 
		query.append("			, AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("			, HNGR_CGO_QTY" ).append("\n"); 
		query.append("			, CFS_CGO_QTY" ).append("\n"); 
		query.append("			, K.CRE_USR_ID" ).append("\n"); 
		query.append("			, K.CRE_DT" ).append("\n"); 
		query.append("			, K.UPD_USR_ID" ).append("\n"); 
		query.append("			, K.UPD_DT" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("			  @[yd_cd]			-- YD_CD" ).append("\n"); 
		query.append("			, @[vsl_cd]			-- VSL_CD" ).append("\n"); 
		query.append("			, @[skd_voy_no]		-- SKD_VOY_NO" ).append("\n"); 
		query.append("			, @[skd_dir_cd]		-- SKD_DIR_CD" ).append("\n"); 
		query.append("			, @[io_bnd_cd]		-- IO_BND_CD" ).append("\n"); 
		query.append("			, @[cntr_tpsz_cd]	-- CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			, @[ts_flg]			-- TS_FLG" ).append("\n"); 
		query.append("			, @[full_mty_cd]	-- FULL_MTY_CD" ).append("\n"); 
		query.append("			, @[cntr_ttl_qty]	-- CNTR_TTL_QTY" ).append("\n"); 
		query.append("			, @[dcgo_qty]		-- DCGO_QTY" ).append("\n"); 
		query.append("			, @[rc_qty]			-- RC_QTY" ).append("\n"); 
		query.append("			, @[dg_rc_qty]		-- DG_RC_QTY" ).append("\n"); 
		query.append("			, @[awk_cgo_qty]	-- AWK_CGO_QTY" ).append("\n"); 
		query.append("			, @[bb_cgo_qty]		-- BB_CGO_QTY" ).append("\n"); 
		query.append("			, @[awk_bb_cgo_qty]	-- AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("			, @[hngr_cgo_qty]	-- HNGR_CGO_QTY" ).append("\n"); 
		query.append("			, @[cfs_cgo_qty]	-- CFS_CGO_QTY" ).append("\n"); 
		query.append("			, 'Batch'" ).append("\n"); 
		query.append("			, SYSDATE" ).append("\n"); 
		query.append("			, 'Batch'" ).append("\n"); 
		query.append("			, SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}