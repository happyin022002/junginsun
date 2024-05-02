/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOAddBkgHisDtlLineCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOAddBkgHisDtlLineCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOAddBkgHisDtlLineCSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOAddBkgHisDtlLineCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOAddBkgHisDtlLineCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_HIS_DTL (" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("          , HIS_SEQ" ).append("\n"); 
		query.append("          , HIS_DTL_SEQ" ).append("\n"); 
		query.append("          , CRNT_CTNT" ).append("\n"); 
		query.append("		  , PRE_CTNT" ).append("\n"); 
		query.append("          , HIS_CATE_NM" ).append("\n"); 
		query.append("          , CA_FLG" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[bkg_no]" ).append("\n"); 
		query.append("      , @[his_seq]" ).append("\n"); 
		query.append("      , NVL((SELECT /*+ INDEX_DESC(BKG_HIS_DTL XPKBKG_HIS_DTL)  */   " ).append("\n"); 
		query.append("                     HIS_DTL_SEQ" ).append("\n"); 
		query.append("                FROM BKG_HIS_DTL   " ).append("\n"); 
		query.append("               WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                 AND HIS_SEQ = @[his_seq]" ).append("\n"); 
		query.append("                 AND ROWNUM = 1),0)+1" ).append("\n"); 
		query.append("      , @[crnt_ctnt]" ).append("\n"); 
		query.append("	  , @[pre_ctnt]" ).append("\n"); 
		query.append("      , @[his_cate_nm]" ).append("\n"); 
		query.append("      , 'N'" ).append("\n"); 
		query.append("      , NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("      , NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("--Batch call AutoratingTaxCalculate Hard Coding 'TAXBATCH'" ).append("\n"); 
		query.append("#if(${cre_usr_id} == 'TAXBATCH')" ).append("\n"); 
		query.append("	  ,	GLOBALDATE_PKG.TIME_LOCAL_FNC('KRPUS')" ).append("\n"); 
		query.append("	  ,	GLOBALDATE_PKG.TIME_LOCAL_FNC('KRPUS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      , sysdate" ).append("\n"); 
		query.append("      , sysdate" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}