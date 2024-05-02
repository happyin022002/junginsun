/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgBkgHisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.18 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgBkgHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cod confirm시 변경된 값을 bkg_bkg_his에 update한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgBkgHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgBkgHisUSQL").append("\n"); 
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
		query.append("update bkg_bkg_his set (POR_CD" ).append("\n"); 
		query.append(", POR_NOD_CD" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POL_NOD_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", POD_NOD_CD" ).append("\n"); 
		query.append(", DEL_CD" ).append("\n"); 
		query.append(", DEL_NOD_CD" ).append("\n"); 
		query.append(", de_term_cd" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", pctl_no)=" ).append("\n"); 
		query.append("(select  substr(NEW_POR_YD_CD,0,5)" ).append("\n"); 
		query.append(", NEW_POR_YD_CD" ).append("\n"); 
		query.append(", substr(NEW_POL_YD_CD,0,5)" ).append("\n"); 
		query.append(", NEW_POL_YD_CD" ).append("\n"); 
		query.append(", substr(NEW_POD_YD_CD,0,5)" ).append("\n"); 
		query.append(", NEW_POD_YD_CD" ).append("\n"); 
		query.append(", substr(NEW_DEL_YD_CD,0,5)" ).append("\n"); 
		query.append(", NEW_DEL_YD_CD" ).append("\n"); 
		query.append(", new_de_term_cd" ).append("\n"); 
		query.append(", VVD.SLAN_CD" ).append("\n"); 
		query.append(", VVD.VSL_CD" ).append("\n"); 
		query.append(", VVD.SKD_VOY_NO" ).append("\n"); 
		query.append(", VVD.SKD_DIR_CD" ).append("\n"); 
		query.append(", cod.pctl_no" ).append("\n"); 
		query.append("--				, de_term_Cd" ).append("\n"); 
		query.append("from bkg_cod COD, BKG_COD_VVD VVD" ).append("\n"); 
		query.append("where COD.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and COD.cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 
		query.append("AND COD.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND COD.COD_RQST_SEQ = VVD.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND 'T' = VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("AND 'N' = VVD.VVD_OP_CD)" ).append("\n"); 
		query.append(",UPD_USR_ID=@[usr_id]" ).append("\n"); 
		query.append(",UPD_DT=sysdate" ).append("\n"); 
		query.append("where bkg_no =@[bkg_no]" ).append("\n"); 
		query.append("and corr_no= @[corr_no]" ).append("\n"); 

	}
}