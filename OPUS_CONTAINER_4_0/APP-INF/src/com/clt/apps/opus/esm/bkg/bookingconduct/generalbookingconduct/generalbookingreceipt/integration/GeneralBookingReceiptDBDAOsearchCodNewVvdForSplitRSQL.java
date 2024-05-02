/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchCodNewVvdForSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.31 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchCodNewVvdForSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 route가 적용되는 bkg에 대해 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchCodNewVvdForSplitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codRqstSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchCodNewVvdForSplitRSQL").append("\n"); 
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
		query.append("select VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", VSL_SEQ" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", substr(POL_YD_CD, 1, 5) pol_cd" ).append("\n"); 
		query.append(", POL_YD_CD" ).append("\n"); 
		query.append(", POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", substr(POd_YD_CD, 1, 5) pod_cd" ).append("\n"); 
		query.append(", POD_YD_CD" ).append("\n"); 
		query.append(", POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' OP_CD" ).append("\n"); 
		query.append(",'' BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",'' CNTR_LODG_FLG" ).append("\n"); 
		query.append(",'' REV_VVD_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("from bkg_cod_vvd" ).append("\n"); 
		query.append("where vvd_op_cd = 'N'" ).append("\n"); 
		query.append("and bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[codRqstSeq]" ).append("\n"); 

	}
}