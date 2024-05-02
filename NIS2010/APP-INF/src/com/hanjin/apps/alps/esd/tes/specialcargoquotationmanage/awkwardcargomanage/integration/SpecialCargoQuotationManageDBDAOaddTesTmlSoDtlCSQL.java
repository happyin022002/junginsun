/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOaddTesTmlSoDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.25
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.25 이혜민
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

public class SpecialCargoQuotationManageDBDAOaddTesTmlSoDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTesTmlSoDtl
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOaddTesTmlSoDtlCSQL(){
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
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOaddTesTmlSoDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_DTL" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(",TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TML_SO_SEQ" ).append("\n"); 
		query.append(",TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(",CALC_COST_GRP_CD" ).append("\n"); 
		query.append(",CALC_TP_CD" ).append("\n"); 
		query.append(",ATB_DT" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",LGS_COST_CD" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",LOCL_CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",LOCL_UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("( @[bkg_no]                     -- bkg_no" ).append("\n"); 
		query.append(", @[tml_so_ofc_cty_cd] 			-- tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", @[tml_so_seq] 				-- tml_so_seq" ).append("\n"); 
		query.append(", @[tml_so_dtl_seq] 			-- tml_so_dtl_seq" ).append("\n"); 
		query.append(", 'TM' 							-- calc_cost_grp_cd" ).append("\n"); 
		query.append(", 'M' 							-- calc_tp_cd" ).append("\n"); 
		query.append(", TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD') 			-- atb_dt" ).append("\n"); 
		query.append(", SUBSTR(@[vvd],1,4) 			-- vsl_cd" ).append("\n"); 
		query.append(", SUBSTR(@[vvd],5,4) 			-- skd_voy_no" ).append("\n"); 
		query.append(", SUBSTR(@[vvd],9,1) 			-- skd_dir_cd" ).append("\n"); 
		query.append(", @[io_bnd_cd] 					-- io_bnd_cd" ).append("\n"); 
		query.append(", @[lgs_cost_cd] 				-- lgs_cost_cd" ).append("\n"); 
		query.append(", @[inv_amt] 					-- inv_amt" ).append("\n"); 
		query.append(", @[cre_usr_id] 				-- cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[lg_ofc_cd])		-- cre_dt" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[lg_ofc_cd])		-- cre_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}