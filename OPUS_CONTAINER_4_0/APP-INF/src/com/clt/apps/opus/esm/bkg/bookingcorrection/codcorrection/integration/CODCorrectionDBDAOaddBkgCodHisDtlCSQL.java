/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionDBDAOaddBkgCodHisDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.20 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOaddBkgCodHisDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod_his_dtl에 insert한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOaddBkgCodHisDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_his_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOaddBkgCodHisDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_COD_HIS_DTL (" ).append("\n"); 
		query.append("COD_BKG_NO" ).append("\n"); 
		query.append(",	COD_RQST_SEQ" ).append("\n"); 
		query.append(",	COD_HIS_SEQ" ).append("\n"); 
		query.append(",	COD_HIS_DTL_SEQ" ).append("\n"); 
		query.append(",	COD_HIS_ITM_CD" ).append("\n"); 
		query.append(",	OLD_CTNT" ).append("\n"); 
		query.append(",	NEW_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[cod_bkg_no]" ).append("\n"); 
		query.append(",	@[cod_rqst_seq]" ).append("\n"); 
		query.append(",	@[cod_his_seq]" ).append("\n"); 
		query.append(",	(select /*+ index_desc(bkg_cod_his_dtl  XPKBKG_COD_HIS_DTL)  */" ).append("\n"); 
		query.append("nvl(sum(cod_his_dtl_seq),0)+1" ).append("\n"); 
		query.append("from bkg_cod_his_dtl" ).append("\n"); 
		query.append("where cod_bkg_no = @[cod_bkg_no]" ).append("\n"); 
		query.append("and   cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and   rownum = 1" ).append("\n"); 
		query.append("and cod_his_dtl_seq >= 0" ).append("\n"); 
		query.append("and rownum <= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",	@[cod_his_itm_cd]" ).append("\n"); 
		query.append(",	@[old_ctnt]" ).append("\n"); 
		query.append(",	@[new_ctnt]" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}