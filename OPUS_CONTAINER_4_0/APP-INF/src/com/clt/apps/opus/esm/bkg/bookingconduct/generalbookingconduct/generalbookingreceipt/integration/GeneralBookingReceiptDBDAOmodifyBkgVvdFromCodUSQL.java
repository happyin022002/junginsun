/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgVvdFromCodUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.25 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgVvdFromCodUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgVvdFromCodUSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgVvdFromCodUSQL").append("\n"); 
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
		query.append("insert into bkg_vvd(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", VSL_SEQ" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", OP_CD" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POL_YD_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", POD_YD_CD" ).append("\n"); 
		query.append(", POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", CNTR_LODG_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", VSL_SEQ" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", VVD_OP_CD" ).append("\n"); 
		query.append(", substr(POL_YD_CD,1,5) POL_CD" ).append("\n"); 
		query.append(", case when length(POL_YD_CD)=7 then POL_YD_CD else '' end  POL_YD_CD" ).append("\n"); 
		query.append(", substr(POD_YD_CD,1,5) POD_CD" ).append("\n"); 
		query.append(", case when length(POD_YD_CD)=7 then POD_YD_CD else '' end  POD_YD_CD" ).append("\n"); 
		query.append(", POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("FROM BKG_COD_VVD" ).append("\n"); 
		query.append("where BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and vvd_op_cd ='N'" ).append("\n"); 

	}
}