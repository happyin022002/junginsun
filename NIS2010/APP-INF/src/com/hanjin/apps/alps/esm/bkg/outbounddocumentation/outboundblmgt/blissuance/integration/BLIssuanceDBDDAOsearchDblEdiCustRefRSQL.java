/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDDAOsearchDblEdiCustRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.30 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDDAOsearchDblEdiCustRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDDAOsearchDblEdiCustRefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDDAOsearchDblEdiCustRefRSQL").append("\n"); 
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
		query.append("SELECT 'BKG_CUST_REF_NO:' ||NVL(REFN.BKG_CUST_REF_NO, ' ') || CHR(10) ||" ).append("\n"); 
		query.append("'BKG_SH_REF_NO:'   ||NVL(REFN.BKG_SH_REF_NO, ' ')   || CHR(10) ||" ).append("\n"); 
		query.append("'BKG_FF_REF_NO:'   ||NVL(REFN.BKG_FF_REF_NO, ' ')   || CHR(10) ||" ).append("\n"); 
		query.append("'SI_CUST_REF_NO:'  ||NVL(REFN.SI_CUST_REF_NO, ' ')  || CHR(10) ||" ).append("\n"); 
		query.append("'SI_SH_REF_NO:'    ||NVL(REFN.SI_SH_REF_NO, ' ')    || CHR(10) ||" ).append("\n"); 
		query.append("'SI_FF_REF_NO:'    ||NVL(REFN.SI_FF_REF_NO, ' ')    || DECODE(@[edi_receive_id], 'PKEXM010', CHR(10) ||" ).append("\n"); 
		query.append("'SI_VIA:' || DECODE(NVL(BK.XTER_SI_CD,' '), 'INT', 'I'," ).append("\n"); 
		query.append("'CSM', 'C'," ).append("\n"); 
		query.append("'EDI', 'E'," ).append("\n"); 
		query.append("'GTN', 'G'," ).append("\n"); 
		query.append("'DKS', 'P'," ).append("\n"); 
		query.append("'WEB', 'W') || CHR(10), CHR(10))" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(",(SELECT BKG_NO" ).append("\n"); 
		query.append(",MAX(DECODE(bkg_ref_tp_cd, 'EBRF', cust_ref_no_ctnt)) AS BKG_CUST_REF_NO" ).append("\n"); 
		query.append(",MAX(DECODE(bkg_ref_tp_cd, 'EBSH', cust_ref_no_ctnt)) AS BKG_SH_REF_NO" ).append("\n"); 
		query.append(",MAX(DECODE(bkg_ref_tp_cd, 'EBFF', cust_ref_no_ctnt)) AS BKG_FF_REF_NO" ).append("\n"); 
		query.append(",MAX(DECODE(bkg_ref_tp_cd, 'ESRF', cust_ref_no_ctnt)) AS SI_CUST_REF_NO" ).append("\n"); 
		query.append(",MAX(DECODE(bkg_ref_tp_cd, 'ESSH', cust_ref_no_ctnt)) AS SI_SH_REF_NO" ).append("\n"); 
		query.append(",MAX(DECODE(bkg_ref_tp_cd, 'ESFF', cust_ref_no_ctnt)) AS SI_FF_REF_NO" ).append("\n"); 
		query.append("FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY BKG_NO) REFN" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = REFN.BKG_NO(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}