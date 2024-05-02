/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyCmFlgBySpclUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOmodifyCmFlgBySpclUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify Container Manifest Flag by Special Cargo
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyCmFlgBySpclUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyCmFlgBySpclUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    UPDATE BKG_CNTR_MF_DESC_HIS SET " ).append("\n"); 
		query.append("        #if (${spcl_tp} == 'RF') " ).append("\n"); 
		query.append("            RC_FLG = 'Y' ," ).append("\n"); 
		query.append("            RD_CGO_FLG = 'N' " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("    #if (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("        AND CNTR_NO IN (SELECT CNTR_NO" ).append("\n"); 
		query.append("                        FROM BKG_RF_CGO_HIS" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND CORR_NO = 'TMP0000001') " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    UPDATE BKG_CNTR_MF_DESC SET " ).append("\n"); 
		query.append("    #if (${spcl_tp} == 'RF') " ).append("\n"); 
		query.append("        RC_FLG = 'Y' ," ).append("\n"); 
		query.append("        RD_CGO_FLG = 'N' " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("    #if (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("        AND CNTR_NO IN (SELECT CNTR_NO" ).append("\n"); 
		query.append("                        FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}