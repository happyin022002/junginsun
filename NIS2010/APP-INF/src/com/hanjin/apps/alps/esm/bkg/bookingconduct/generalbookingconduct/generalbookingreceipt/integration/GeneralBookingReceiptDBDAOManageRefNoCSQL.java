/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOManageRefNoCSQL.java
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

public class GeneralBookingReceiptDBDAOManageRefNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOManageRefNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOManageRefNoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REF_HIS (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_REFERENCE (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    CORR_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	REF_SEQ," ).append("\n"); 
		query.append("	BKG_REF_TP_CD," ).append("\n"); 
		query.append("	CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("	CPY_DESC_FLG," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("   'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("		NVL((SELECT /*+ INDEX_DESC(BKG_REF_HIS XPKBKG_REF_HIS)  */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		NVL((SELECT /*+ INDEX_DESC(BKG_REFERENCE XPKBKG_REFERENCE)  */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 REF_SEQ" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("			FROM BKG_REF_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			FROM BKG_REFERENCE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    		WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("        	AND   CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("			AND   ROWNUM = 1" ).append("\n"); 
		query.append("    ),0)+1)," ).append("\n"); 
		query.append("	@[bkg_ref_tp_cd]," ).append("\n"); 
		query.append("	Replace(Replace(@[cust_ref_no_ctnt],CHR(13),''),CHR(10),'')," ).append("\n"); 
		query.append("	NVL(@[cpy_desc_flg],'N')," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}