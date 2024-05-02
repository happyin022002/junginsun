/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchBkgCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.19
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.19 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchBkgCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCustomer
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchBkgCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration ").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchBkgCustomerRSQL").append("\n"); 
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
		query.append("sh.CUST_CNT_CD s_cust_cnt_cd" ).append("\n"); 
		query.append(", 	sh.CUST_CNT_CD s_cust_cnt_cd_old" ).append("\n"); 
		query.append(", 	DECODE(sh.CUST_SEQ,0,'',LPAD(sh.CUST_SEQ,6,'0')) s_cust_seq" ).append("\n"); 
		query.append(", 	DECODE(sh.CUST_SEQ,0,'',LPAD(sh.CUST_SEQ,6,'0')) s_cust_seq_old" ).append("\n"); 
		query.append(", 	mdm_sh.CUST_LGL_ENG_NM s_cust_nm" ).append("\n"); 
		query.append(", 	CASE" ).append("\n"); 
		query.append("WHEN SH.CUST_NM IS NULL AND SH.CUST_ADDR IS NULL THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END AS S_CUST_EXIST_FLG" ).append("\n"); 
		query.append(", 	cn.CUST_CNT_CD c_cust_cnt_cd" ).append("\n"); 
		query.append(", 	cn.CUST_CNT_CD c_cust_cnt_cd_old" ).append("\n"); 
		query.append(", 	DECODE(cn.CUST_SEQ,0,'',LPAD(cn.CUST_SEQ,6,'0')) c_cust_seq" ).append("\n"); 
		query.append(", 	DECODE(cn.CUST_SEQ,0,'',LPAD(cn.CUST_SEQ,6,'0')) c_cust_seq_old" ).append("\n"); 
		query.append(", 	mdm_cn.CUST_LGL_ENG_NM c_cust_nm" ).append("\n"); 
		query.append(", 	CASE" ).append("\n"); 
		query.append("WHEN CN.CUST_NM IS NULL AND CN.CUST_ADDR IS NULL THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END AS C_CUST_EXIST_FLG" ).append("\n"); 
		query.append(", 	ff.CUST_CNT_CD f_cust_cnt_cd" ).append("\n"); 
		query.append(", 	ff.CUST_CNT_CD f_cust_cnt_cd_old" ).append("\n"); 
		query.append(", 	DECODE(ff.CUST_SEQ,0,'',LPAD(ff.CUST_SEQ,6,'0')) f_cust_seq" ).append("\n"); 
		query.append(", 	DECODE(ff.CUST_SEQ,0,'',LPAD(ff.CUST_SEQ,6,'0')) f_cust_seq_old" ).append("\n"); 
		query.append(", 	mdm_ff.CUST_LGL_ENG_NM f_cust_nm" ).append("\n"); 
		query.append(", 	CASE" ).append("\n"); 
		query.append("WHEN FF.CUST_NM IS NULL AND FF.CUST_ADDR IS NULL THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END AS F_CUST_EXIST_FLG" ).append("\n"); 
		query.append(",   '' S_CUST_SUBST_FLG" ).append("\n"); 
		query.append(",   '' C_CUST_SUBST_FLG" ).append("\n"); 
		query.append(",   '' F_CUST_SUBST_FLG" ).append("\n"); 
		query.append("from   bkg_booking bk" ).append("\n"); 
		query.append(", bkg_customer sh" ).append("\n"); 
		query.append(", bkg_customer cn" ).append("\n"); 
		query.append(", bkg_customer ff" ).append("\n"); 
		query.append(", mdm_customer mdm_sh" ).append("\n"); 
		query.append(", mdm_customer mdm_cn" ).append("\n"); 
		query.append(", mdm_customer mdm_ff" ).append("\n"); 
		query.append("where bk.bkg_no       = sh.bkg_no" ).append("\n"); 
		query.append("and 'S'             = sh.bkg_cust_tp_cd" ).append("\n"); 
		query.append("and bk.bkg_no       = cn.bkg_no(+)" ).append("\n"); 
		query.append("and 'C'             = CN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = ff.bkg_no(+)" ).append("\n"); 
		query.append("and 'F'             = FF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("and sh.cust_cnt_cd  = mdm_sh.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and sh.cust_seq     = mdm_sh.cust_seq(+)" ).append("\n"); 
		query.append("and cn.cust_cnt_cd  = mdm_cn.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and cn.cust_seq     = mdm_cn.cust_seq(+)" ).append("\n"); 
		query.append("and ff.cust_cnt_cd  = mdm_ff.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and ff.cust_seq     = mdm_ff.cust_seq(+)" ).append("\n"); 
		query.append("and bk.bkg_no       = @[bkg_no]" ).append("\n"); 

	}
}