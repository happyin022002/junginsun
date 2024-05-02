/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgQuantityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgQuantityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistNewBkgQuantityRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgQuantityRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgQuantityRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'BKG QTY' HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/'||NVL(NOW.OP_CNTR_QTY, 0)||" ).append("\n"); 
		query.append("DECODE(NVL(NOW.BB_CGO_QTY, 0), 0, '', '/D:'||NOW.DCGO_QTY)||" ).append("\n"); 
		query.append("DECODE(NVL(NOW.RC_QTY,     0), 0, '', '/R:'||NOW.RC_QTY)||" ).append("\n"); 
		query.append("DECODE(NVL(NOW.AWK_CGO_QTY,0), 0, '', '/A:'||NOW.AWK_CGO_QTY)||" ).append("\n"); 
		query.append("DECODE(NVL(NOW.BB_CGO_QTY, 0), 0, '', '/B:'||NOW.BB_CGO_QTY)||" ).append("\n"); 
		query.append("DECODE(NVL(NOW.EQ_SUBST_CNTR_TPSZ_CD, 'X'), 'X', ''," ).append("\n"); 
		query.append("'/SUB:'||NOW.EQ_SUBST_CNTR_TPSZ_CD||'/'||NVL(NOW.EQ_SUBST_CGO_QTY, 0)) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("FROM BKG_QTY_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND NOW.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_QUANTITY NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, CNTR_TPSZ_CD) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'HANGER' HIS_CATE_NM" ).append("\n"); 
		query.append(", '' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.CNTR_TPSZ_CD||" ).append("\n"); 
		query.append("'/Merchant:'||NVL(NOW.MER_HNGR_QTY, 0)||" ).append("\n"); 
		query.append("'/Carrier:'||NVL(NOW.CRR_HNGR_QTY,  0)||" ).append("\n"); 
		query.append("'(s:'||NVL(NOW.CRR_HNGR_SGL_BAR_QTY, 0)||" ).append("\n"); 
		query.append("'/d:'||NVL(NOW.CRR_HNGR_DBL_BAR_QTY, 0)||" ).append("\n"); 
		query.append("'/t:'||NVL(NOW.CRR_HNGR_TPL_BAR_QTY, 0)||')' CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("FROM BKG_QTY_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND NOW.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_QUANTITY NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("AND (BKG_NO, CNTR_TPSZ_CD) NOT IN (" ).append("\n"); 
		query.append("#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (NOW.MER_HNGR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_SGL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_DBL_BAR_QTY > 0" ).append("\n"); 
		query.append("OR NOW.CRR_HNGR_TPL_BAR_QTY > 0)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 

	}
}