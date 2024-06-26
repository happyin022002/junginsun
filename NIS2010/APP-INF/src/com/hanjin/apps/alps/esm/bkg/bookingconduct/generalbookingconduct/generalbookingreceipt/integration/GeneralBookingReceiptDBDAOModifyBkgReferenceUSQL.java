/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgReferenceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.02
*@LastModifier : 최문환
*@LastVersion : 1.0
* 2013.08.02 최문환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Moonhwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBkgReferenceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * reference no 정보를 수정한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgReferenceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ref_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgReferenceUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SET    " ).append("\n"); 
		query.append("       CUST_REF_NO_CTNT   = Replace(Replace(@[cust_ref_no_ctnt],CHR(13),''),CHR(10),'')," ).append("\n"); 
		query.append("       UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT        = sysdate" ).append("\n"); 
		query.append("WHERE  BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND    REF_SEQ       = @[ref_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}