/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOXterRqutMstUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.10.29 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOXterRqutMstUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSplitCombineDBDAOXterRqutMstUpdateUSQL
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOXterRqutMstUpdateUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taget_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOXterRqutMstUpdateUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("SET MST.BKG_NO = @[taget_bkg_no]" ).append("\n"); 
		query.append(", MST.BL_NO_CTNT = @[taget_bkg_no]" ).append("\n"); 
		query.append("    , MST.CRE_USR_ID = 'SPLIT'" ).append("\n"); 
		query.append("	, dpcs_split_no = 'L' " ).append("\n"); 
		query.append("WHERE MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND MST.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("AND MST.XTER_RQST_VIA_CD = 'WEB'" ).append("\n"); 
		query.append("AND MST.CRE_USR_ID = 'HOM1'" ).append("\n"); 
		query.append("AND MST.SPLIT_STS_CD = 'S'" ).append("\n"); 
		query.append("AND MST.BL_SPLIT_NO = @[bl_split_no]" ).append("\n"); 

	}
}