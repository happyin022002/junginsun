/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Invoice210EdiDBDAOSearchInvCfmSORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2012.04.02 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSearchInvCfmSORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvCfmSO SELECT
	  * </pre>
	  */
	public Invoice210EdiDBDAOSearchInvCfmSORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSearchInvCfmSORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ       ," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_WO_SEQ       ," ).append("\n"); 
		query.append("A.INV_NO            ," ).append("\n"); 
		query.append("A.INV_VNDR_SEQ      ," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM  TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(",TRS_TRSP_INV_WRK B" ).append("\n"); 
		query.append("WHERE A.INV_NO   = @[inv_no]" ).append("\n"); 
		query.append("AND   A.INV_VNDR_SEQ = NVL((SELECT NVL(V.PRNT_VNDR_SEQ, V.VNDR_SEQ)" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append(",MDM_VENDOR       V" ).append("\n"); 
		query.append("WHERE S.VNDR_SEQ           = V.VNDR_SEQ" ).append("\n"); 
		query.append("AND S.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND S.TRSP_SO_SEQ        = @[trsp_so_seq]" ).append("\n"); 
		query.append("), A.INV_VNDR_SEQ)" ).append("\n"); 
		query.append("AND   A.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND   A.INV_NO   = B.INV_NO" ).append("\n"); 
		query.append("AND   A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND   B.TRSP_INV_AUD_STS_CD  <> 'RC'" ).append("\n"); 
		query.append("AND   A.HJL_NO IS NULL" ).append("\n"); 

	}
}