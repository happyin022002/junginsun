/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationBLDBDAOCreateCntrSealCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.31
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.01.31 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOCreateCntrSealCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOCreateCntrSealCACSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOCreateCntrSealCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOCreateCntrSealCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_SEAL_NO (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_SEAL_NO_HIS (" ).append("\n"); 
		query.append("    BKG_NO " ).append("\n"); 
		query.append("    , CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , CNTR_NO " ).append("\n"); 
		query.append("    , CNTR_SEAL_SEQ " ).append("\n"); 
		query.append("    , CNTR_SEAL_NO " ).append("\n"); 
		query.append("    , SEAL_PTY_NM " ).append("\n"); 
		query.append("    , PRN_FLG " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , SEAL_PTY_TP_CD " ).append("\n"); 
		query.append("    , SEAL_KND_CD " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT HIS.BKG_NO " ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT HIS.BKG_NO " ).append("\n"); 
		query.append("        , 'TMP0000001' CORR_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT HIS.BKG_NO " ).append("\n"); 
		query.append("        , @[ca_no] CORR_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , HIS.CNTR_NO " ).append("\n"); 
		query.append("        , HIS.CNTR_SEAL_SEQ " ).append("\n"); 
		query.append("        , HIS.CNTR_SEAL_NO " ).append("\n"); 
		query.append("        , HIS.SEAL_PTY_NM " ).append("\n"); 
		query.append("        , HIS.PRN_FLG " ).append("\n"); 
		query.append("        , HIS.CRE_USR_ID " ).append("\n"); 
		query.append("        , HIS.CRE_DT " ).append("\n"); 
		query.append("        , HIS.UPD_USR_ID " ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , HIS.SEAL_PTY_TP_CD " ).append("\n"); 
		query.append("        , HIS.SEAL_KND_CD " ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("  FROM BKG_CNTR_SEAL_NO_HIS HIS, BKG_CNTR_HIS CNTR " ).append("\n"); 
		query.append(" WHERE HIS.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND HIS.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND HIS.CORR_NO = CNTR.CORR_NO" ).append("\n"); 
		query.append("   AND HIS.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND HIS.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_CNTR_SEAL_NO HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}