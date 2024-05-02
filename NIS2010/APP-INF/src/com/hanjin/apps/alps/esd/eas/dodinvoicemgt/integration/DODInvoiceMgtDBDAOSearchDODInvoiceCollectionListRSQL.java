/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchDODInvoiceCollectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchDODInvoiceCollectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DODInvoiceMgtDBDAOSearchDODInvoiceCollectionListRSQL
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchDODInvoiceCollectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ar_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ar_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchDODInvoiceCollectionListRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(E.AR_IF_DT,'YYYY-MM-DD') AS AR_IF_DT,  " ).append("\n"); 
		query.append("       E.DOD_INV_NO, " ).append("\n"); 
		query.append("       E.BL_NO, " ).append("\n"); 
		query.append("       D.CNTR_NO, " ).append("\n"); 
		query.append("       D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       E.CRE_OFC_CD, " ).append("\n"); 
		query.append("       D.DOD_LOC_CD," ).append("\n"); 
		query.append("       D.INV_AMT, D.TAX_AMT, D.BIL_AMT, D.ADD_AMT," ).append("\n"); 
		query.append("	   B.POR_CD,  B.POL_CD,  B.POD_CD,  B.DEL_CD," ).append("\n"); 
		query.append("	  (	SELECT K.CUST_NM  " ).append("\n"); 
		query.append("        FROM   BKG_CUSTOMER K" ).append("\n"); 
		query.append("	   	WHERE  K.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("  	    AND    K.BKG_CUST_TP_CD ='C' ) AS CNEE ," ).append("\n"); 
		query.append("	  ( SELECT K.CUST_NM" ).append("\n"); 
		query.append("	    FROM   BKG_CUSTOMER K" ).append("\n"); 
		query.append("		WHERE  K.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("  	    AND    K.BKG_CUST_TP_CD ='N' ) AS NFTY," ).append("\n"); 
		query.append("       PA.PAYR_NM  PAYER" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_MN E," ).append("\n"); 
		query.append("     BKG_BOOKING B, " ).append("\n"); 
		query.append("     EAS_DOD_INV_DTL D," ).append("\n"); 
		query.append("     MDM_LOCATION M," ).append("\n"); 
		query.append("     EAS_PAYR_INFO PA" ).append("\n"); 
		query.append("WHERE E.DOD_INV_NO = D.DOD_INV_NO" ).append("\n"); 
		query.append("AND   E.DOD_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("#if(${do_loc} != '' && ${do_loc} != 'null' && ${do_loc} != 'A' )" ).append("\n"); 
		query.append("AND  D.DOD_LOC_CD IN (${do_loc})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_ofc_cd} != '' && ${cre_ofc_cd} != 'null' && ${cre_ofc_cd} != 'A' )" ).append("\n"); 
		query.append("AND  E.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND E.AR_IF_DT >= to_date(@[fm_ar_if_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("AND E.AR_IF_DT <= to_date(@[to_ar_if_dt],'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("AND E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.POR_CD = nvl(@[por_cd] , B.POR_CD)" ).append("\n"); 
		query.append("AND B.POL_CD = nvl(@[pol_cd] , B.POL_CD)" ).append("\n"); 
		query.append("AND B.POD_CD = nvl(@[pod_cd] , B.POD_CD)" ).append("\n"); 
		query.append("AND B.DEL_CD = nvl(@[del_cd] , B.DEL_CD)" ).append("\n"); 
		query.append("AND B.POL_CD = m.loc_cd" ).append("\n"); 
		query.append("AND M.CONTI_CD    = DECODE(@[conti_cd],'X', M.CONTI_CD, @[conti_cd])" ).append("\n"); 
		query.append("AND E.CUST_CNT_CD = PA.CUST_CNT_CD" ).append("\n"); 
		query.append("AND E.CUST_SEQ    = PA.CUST_SEQ" ).append("\n"); 
		query.append("ORDER BY E.AR_IF_DT" ).append("\n"); 

	}
}