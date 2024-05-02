/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOmanageTesTmlSoBbDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.16 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOmanageTesTmlSoBbDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * manageTesTmlSoBbDtl
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOmanageTesTmlSoBbDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_tp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOmanageTesTmlSoBbDtlUSQL").append("\n"); 
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
		query.append("MERGE INTO TES_TML_SO_BB_DTL BD" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON (    BD.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND BD.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND BD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BD.BB_CGO_TP_SEQ = @[bb_cgo_tp_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("INV_AMT = @[inv_amt]," ).append("\n"); 
		query.append("BB_CGO_RMK = @[bb_cgo_rmk]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_SO_SEQ," ).append("\n"); 
		query.append("TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("BB_CGO_TP_SEQ," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("BB_CGO_RMK," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[tml_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[tml_so_seq]," ).append("\n"); 
		query.append("@[tml_so_dtl_seq]," ).append("\n"); 
		query.append("@[bb_cgo_tp_seq]," ).append("\n"); 
		query.append("@[lgs_cost_cd]," ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[inv_amt]," ).append("\n"); 
		query.append("@[bb_cgo_rmk]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}