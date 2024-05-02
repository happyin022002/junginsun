/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOAddReplanPatternsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOAddReplanPatternsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRD_BKG_COP_MAP 테이블의 데이터 insert
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOAddReplanPatternsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_itchg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_itchg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_op_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_patt_ord_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_op_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_itchg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_so_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOAddReplanPatternsCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_BKG_COP_MAP " ).append("\n"); 
		query.append("(   BKG_NO," ).append("\n"); 
		query.append("    PCTL_NO," ).append("\n"); 
		query.append("    COP_NO," ).append("\n"); 
		query.append("    COP_MAPG_SEQ," ).append("\n"); 
		query.append("    CRNT_FLG," ).append("\n"); 
		query.append("    COP_OP_TP_CD," ).append("\n"); 
		query.append("    CNTR_NO," ).append("\n"); 
		query.append("    BKG_OP_RMK," ).append("\n"); 
		query.append("    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    COP_SO_KNT," ).append("\n"); 
		query.append("--    MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("    MTY_RTN_YD_CD," ).append("\n"); 
		query.append("    OB_TRO_FLG," ).append("\n"); 
		query.append("    IB_TRO_FLG," ).append("\n"); 
		query.append("    POR_NOD_CD," ).append("\n"); 
		query.append("    POL_NOD_CD," ).append("\n"); 
		query.append("    BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("    BKG_DE_TERM_CD," ).append("\n"); 
		query.append("    OB_ITCHG_CTNT," ).append("\n"); 
		query.append("    IB_ITCHG_CTNT," ).append("\n"); 
		query.append("    OCN_ITCHG_CTNT," ).append("\n"); 
		query.append("    COP_PATT_ORD_NO," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("    @[bkg_no]," ).append("\n"); 
		query.append("    @[pctl_no]," ).append("\n"); 
		query.append("    @[cop_no]," ).append("\n"); 
		query.append("    @[cop_mapg_seq]," ).append("\n"); 
		query.append("    @[crnt_flg]," ).append("\n"); 
		query.append("    @[cop_op_tp_cd]," ).append("\n"); 
		query.append("    @[cntr_no]," ).append("\n"); 
		query.append("    @[bkg_op_rmk]," ).append("\n"); 
		query.append("    @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("    @[cop_so_knt]," ).append("\n"); 
		query.append("--    :mty_pkup_yd_cd," ).append("\n"); 
		query.append("    @[mty_rtn_yd_cd]," ).append("\n"); 
		query.append("    @[ob_tro_flg]," ).append("\n"); 
		query.append("    @[ib_tro_flg]," ).append("\n"); 
		query.append("    @[por_nod_cd]," ).append("\n"); 
		query.append("    @[pol_nod_cd]," ).append("\n"); 
		query.append("    @[bkg_rcv_term_cd]," ).append("\n"); 
		query.append("    @[bkg_de_term_cd]," ).append("\n"); 
		query.append("    @[ob_itchg_ctnt]," ).append("\n"); 
		query.append("    @[ib_itchg_ctnt]," ).append("\n"); 
		query.append("    @[ocn_itchg_ctnt]," ).append("\n"); 
		query.append("    @[cop_patt_ord_no]," ).append("\n"); 
		query.append("    'SYSTEM'," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    'SYSTEM'," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}