/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLDBDAOSelectCompareBkgRevUmchBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.12.01 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSelectCompareBkgRevUmchBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectCompareBkgRevUmchBkg
	  * </pre>
	  */
	public UnmatchBLDBDAOSelectCompareBkgRevUmchBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_umch_bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSelectCompareBkgRevUmchBkgRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO, BKG_CORR_NO" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    UMCH_BKG_SEQ = TO_NUMBER(@[max_umch_bkg_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO, BKG_CORR_NO" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    UMCH_BKG_SEQ = TO_NUMBER(@[max_umch_bkg_seq]) - 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO, BKG_CORR_NO" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    UMCH_BKG_SEQ = TO_NUMBER(@[max_umch_bkg_seq]) - 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO, BKG_CORR_NO" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("WHERE  BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    UMCH_BKG_SEQ = TO_NUMBER(@[max_umch_bkg_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}