/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchEdiStsForPrtlBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2010.11.18 조풍연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author poong yeon cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchEdiStsForPrtlBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pratil Bkg를 포함하여 EDI Status를 조회
	  * </pre>
	  */
	public Edi315SendDBDAOSearchEdiStsForPrtlBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchEdiStsForPrtlBkgRSQL").append("\n"); 
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
		query.append("COUNT(R.EDI_GRP_CD) SEND_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("  SCE_EDI_SND_RSLT R" ).append("\n"); 
		query.append(", SCE_COP_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.EDI_GRP_CD = @[v_edi_grp_cd] --'USA00094'" ).append("\n"); 
		query.append("AND R.EDI_STS_CD = 'OAN'" ).append("\n"); 
		query.append("AND R.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND R.CNTR_NO =A.CNTR_NO" ).append("\n"); 
		query.append("AND A.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("  SELECT 'X' FROM" ).append("\n"); 
		query.append("  SCE_COP_HDR B" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("  AND B.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("  AND B.TRNK_VSL_CD = A.TRNK_VSL_CD" ).append("\n"); 
		query.append("  AND B.TRNK_SKD_VOY_NO = A.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("  AND B.TRNK_SKD_DIR_CD = B.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("  AND B.BKG_NO =  @[v_bkg_no]" ).append("\n"); 
		query.append("  AND B.CNTR_NO = @[v_cntr_no]" ).append("\n"); 
		query.append("  AND B.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}