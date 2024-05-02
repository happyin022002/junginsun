/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchDODInvoiceCollectionSummaryRSQL.java
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

public class DODInvoiceMgtDBDAOSearchDODInvoiceCollectionSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DODInvoiceMgtDBDAOSearchDODInvoiceCollectionSummaryRSQL
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchDODInvoiceCollectionSummaryRSQL(){
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
		query.append("FileName : DODInvoiceMgtDBDAOSearchDODInvoiceCollectionSummaryRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    T.SUM_INV_AMT, T.SUM_TAX_AMT, T.TOT_AMT,T.SUM_BIL_AMT," ).append("\n"); 
		query.append("    D2,D4,D5,D7,D8,D9,DW,DX,R2,R4,R5,F2,F4,F5,O2,O4,O5,S2,S4,T2,T4,A2,A4,P2,P4" ).append("\n"); 
		query.append("    ,(D2+R2+F2+O2+T2+A2+P2) TOTAL20" ).append("\n"); 
		query.append("    ,(D4+D5+D7+D8+D9+DW+DX+R4+R5+F4+F5+O4+O5+S4+T4+A4+P4) TOTAL40" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("  SELECT " ).append("\n"); 
		query.append("        SUM(D.INV_AMT) over() SUM_INV_AMT" ).append("\n"); 
		query.append("      , SUM(D.BIL_AMT + NVL(D.ADD_AMT,0)) over() SUM_BIL_AMT" ).append("\n"); 
		query.append("      , SUM(D.TAX_AMT) over() SUM_TAX_AMT" ).append("\n"); 
		query.append("      ,(SUM(D.BIL_AMT + NVL(D.ADD_AMT,0)) over() +  SUM(D.TAX_AMT) over() ) tot_amt" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'D2', 1,0)) over() d2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'D4', 1,0)) over() d4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'D5', 1,0)) over() d5" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'D7', 1,0)) over() d7" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'D8', 1,0)) over() d8" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'D9', 1,0)) over() d9" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'DW', 1,0)) over() dw" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'DX', 1,0)) over() dx" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'R2', 1,0)) over() r2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'R4', 1,0)) over() r4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'R5', 1,0)) over() r5" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'F2', 1,0)) over() f2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'F4', 1,0)) over() f4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'F5', 1,0)) over() f5" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'O2', 1,0)) over() o2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'O4', 1,0)) over() o4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'O5', 1,0)) over() o5" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'S2', 1,0)) over() s2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'S4', 1,0)) over() s4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'T2', 1,0)) over() t2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'T4', 1,0)) over() t4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'A2', 1,0)) over() a2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'A4', 1,0)) over() a4" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'P2', 1,0)) over() p2" ).append("\n"); 
		query.append("      , SUM(DECODE( D.CNTR_TPSZ_CD ,'P4', 1,0)) over() p4" ).append("\n"); 
		query.append(" FROM  EAS_DOD_INV_MN E,BKG_BOOKING B, EAS_DOD_INV_DTL D  " ).append("\n"); 
		query.append("      ,MDM_LOCATION M" ).append("\n"); 
		query.append(" WHERE E.DOD_INV_NO = D.DOD_INV_NO" ).append("\n"); 
		query.append("   AND E.DOD_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("#if(${do_loc} != '' && ${do_loc} != 'null' && ${do_loc} != 'A' )" ).append("\n"); 
		query.append("	AND D.DOD_LOC_CD IN (${do_loc})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_ofc_cd} != '' && ${cre_ofc_cd} != 'null' && ${cre_ofc_cd} != 'A' )" ).append("\n"); 
		query.append("AND E.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("	AND E.AR_IF_DT >= to_date(@[fm_ar_if_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("	AND E.AR_IF_DT <= to_date(@[to_ar_if_dt],'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("	AND E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND B.POR_CD = nvl(@[por_cd] , B.POR_CD)" ).append("\n"); 
		query.append("	AND B.POL_CD = nvl(@[pol_cd] , B.POL_CD)" ).append("\n"); 
		query.append("	AND B.POD_CD = nvl(@[pod_cd] , B.POD_CD)" ).append("\n"); 
		query.append("	AND B.DEL_CD = nvl(@[del_cd] , B.DEL_CD)" ).append("\n"); 
		query.append("	AND B.POL_CD = m.loc_cd" ).append("\n"); 
		query.append("	AND M.CONTI_CD = DECODE(@[conti_cd],'X', M.CONTI_CD, @[conti_cd])" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("where rownum =1" ).append("\n"); 

	}
}