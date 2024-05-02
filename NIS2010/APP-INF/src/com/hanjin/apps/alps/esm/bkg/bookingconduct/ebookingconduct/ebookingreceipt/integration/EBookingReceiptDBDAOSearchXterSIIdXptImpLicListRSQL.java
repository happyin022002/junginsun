/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterSIIdXptImpLicListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.21
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.21 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterSIIdXptImpLicListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * alps의 export/import licens no를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterSIIdXptImpLicListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterSIIdXptImpLicListRSQL").append("\n"); 
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
		query.append("SELECT XX.BKG_NO," ).append("\n"); 
		query.append("       'O' IO_BND_CD," ).append("\n"); 
		query.append("	   'ID' CNT_CD," ).append("\n"); 
		query.append("	   XX.XPT_LIC_NO ID_XPT_NO," ).append("\n"); 
		query.append("	   to_char(XX.ID_XPT_NO_ISS_DT,'yyyyMMdd') ID_XPT_NO_ISS_DT," ).append("\n"); 
		query.append("       NVL(BX.ID_OFC_ID,XX.ID_OFC_ID) ID_OFC_CD," ).append("\n"); 
		query.append("       NVL(BX.ID_DECL_CD,XX.ID_DECL_CD) ID_DECL_CD," ).append("\n"); 
		query.append("       'I' IBFLAG" ).append("\n"); 
		query.append("  FROM (SELECT MST.BKG_NO," ).append("\n"); 
		query.append("               LIC.XPT_LIC_NO," ).append("\n"); 
		query.append("               LIC.ID_XPT_NO_ISS_DT," ).append("\n"); 
		query.append("               NVL(LIC.ID_OFC_ID, '040300') ID_OFC_ID," ).append("\n"); 
		query.append("               NVL(LIC.ID_DECL_CD,'E') ID_DECL_CD" ).append("\n"); 
		query.append("          FROM BKG_XTER_RQST_MST MST, " ).append("\n"); 
		query.append("               BKG_XTER_XPT_LIC_NO LIC" ).append("\n"); 
		query.append("         WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("   		   AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("   		   AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("           AND MST.XTER_SNDR_ID  = LIC.XTER_SNDR_ID" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_NO  = LIC.XTER_RQST_NO" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_SEQ = LIC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("           AND LIC.CNT_CD        = 'ID'" ).append("\n"); 
		query.append("       ) XX," ).append("\n"); 
		query.append("      BKG_XPT_IMP_LIC   BX" ).append("\n"); 
		query.append(" WHERE XX.BKG_NO = BX.BKG_NO(+)" ).append("\n"); 
		query.append("   AND XX.XPT_LIC_NO = BX.ID_XPT_NO(+)" ).append("\n"); 
		query.append("   AND BX.IO_BND_CD(+) = 'O'" ).append("\n"); 
		query.append("   AND BX.CNT_CD(+) = 'ID'" ).append("\n"); 

	}
}