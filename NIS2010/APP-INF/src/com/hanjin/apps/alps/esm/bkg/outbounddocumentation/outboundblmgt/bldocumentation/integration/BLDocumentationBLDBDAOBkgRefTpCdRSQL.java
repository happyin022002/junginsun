/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOBkgRefTpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOBkgRefTpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRefTpCd
	  * </pre>
	  */
	public BLDocumentationBLDBDAOBkgRefTpCdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOBkgRefTpCdRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_FNC(CURSOR(SELECT A.BKG_REF_TP_ML_CD" ).append("\n"); 
		query.append("                             FROM (SELECT DECODE(B.BKG_REF_TP_CD," ).append("\n"); 
		query.append("                                                'BKPO','POB'," ).append("\n"); 
		query.append("                                                'CTPO','POC'," ).append("\n"); 
		query.append("                                                'CMPO','POM'," ).append("\n"); 
		query.append("                                                'HINV','INV'," ).append("\n"); 
		query.append("                                                'HPDP','DPT'," ).append("\n"); 
		query.append("                                                'LCNO','LCN'," ).append("\n"); 
		query.append("                                                'HPSH','SHP'," ).append("\n"); 
		query.append("                                                'HPPN','PRT'," ).append("\n"); 
		query.append("												'MSLD','MSL'," ).append("\n"); 
		query.append("                                                'INCO','INC','N') AS BKG_REF_TP_ML_CD" ).append("\n"); 
		query.append("                                    FROM BKG_BOOKING A" ).append("\n"); 
		query.append("                                        ,BKG_REFERENCE B" ).append("\n"); 
		query.append("                                   WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                                     AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                   UNION " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                   SELECT COLUMN_VALUE AS BKG_REF_TP_ML_CD FROM TABLE (BKG_SPLIT_FNC(('POB,POC,POM,MSL'),',')) " ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND EXISTS (SELECT 'POYN' AS BKG_REF_TP_CD " ).append("\n"); 
		query.append("                                                    FROM BKG_REFERENCE" ).append("\n"); 
		query.append("                                                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                     AND BKG_REF_TP_CD IN ('BKPO','LCNO','HINV','LCDT','HPDP','CTPO','INCO','MSLD')" ).append("\n"); 
		query.append("                                                     AND CUST_REF_NO_CTNT IS NOT NULL  " ).append("\n"); 
		query.append("                                                  )   " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                   UNION" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("                                   SELECT 'SHP' AS BKG_REF_TP_ML_CD" ).append("\n"); 
		query.append("                                     FROM BKG_REF_DTL" ).append("\n"); 
		query.append("                                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                      AND DE_NO IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                   UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                   SELECT 'PRT' AS BKG_REF_TP_ML_CD" ).append("\n"); 
		query.append("                                     FROM BKG_REF_DTL" ).append("\n"); 
		query.append("                                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                      AND PRT_NO IS NOT NULL" ).append("\n"); 
		query.append("                                   ) A" ).append("\n"); 
		query.append("                            #if (${r_po_other_mdt_itm} != '' && $r_po_other_mdt_itm.size() > 0)" ).append("\n"); 
		query.append("                            WHERE A.BKG_REF_TP_ML_CD IN ( NULL" ).append("\n"); 
		query.append("	                                                     #foreach($r_po_other_mdt_itm IN ${r_po_other_mdt_itm})" ).append("\n"); 
		query.append("	 	                                 	             	#if($velocityCount < $r_po_other_mdt_itm.size())" ).append("\n"); 
		query.append("	 	                                    				,'$r_po_other_mdt_itm'," ).append("\n"); 
		query.append("	 	                                    				#else" ).append("\n"); 
		query.append("	 	                                    				,'$r_po_other_mdt_itm'" ).append("\n"); 
		query.append("	 	                                    			 	#end" ).append("\n"); 
		query.append("	                                     				 #end" ).append("\n"); 
		query.append("	                                                     )" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            ORDER BY A.BKG_REF_TP_ML_CD" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}