/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFDgUnNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOSearchCBFIFDgUnNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOSearchCBFIFDgUnNoList
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOSearchCBFIFDgUnNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFDgUnNoListRSQL").append("\n"); 
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
		query.append("		IMDG_UN_NO" ).append("\n"); 
		query.append("		#if (${imdg_subs_rsk_lbl_cd} == 'Y')    " ).append("\n"); 
		query.append("		   , IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	       , IMDG_CLSS_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		B1.IMDG_UN_NO" ).append("\n"); 
		query.append("		#if (${imdg_subs_rsk_lbl_cd} == 'Y')    " ).append("\n"); 
		query.append("		   , ( SELECT IMDG_SUBS_RSK_LBL_CD FROM (SELECT ROW_NUMBER() OVER (PARTITION BY IMDG_UN_NO, IMDG_UN_NO_SEQ ORDER BY IMDG_SUBS_RSK_LBL_CD) RNUM, IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD FROM SCG_IMDG_SUBS_RSK_LBL WHERE IMDG_SUBS_RSK_LBL_CD <> 0) WHERE IMDG_UN_NO = B1.IMDG_UN_NO AND IMDG_UN_NO_SEQ = B1.IMDG_UN_NO_SEQ AND rnum =1 ) IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	       , B1.IMDG_CLSS_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM     SCG_IMDG_UN_NO B1" ).append("\n"); 
		query.append("       , SCG_IMDG_UN_NO_SPCL_PROVI B2" ).append("\n"); 
		query.append("       , SCG_IMDG_UN_NO_ORG_RACT B4" ).append("\n"); 
		query.append("WHERE    B1.IMDG_UN_NO = B2.IMDG_UN_NO (+)" ).append("\n"); 
		query.append("AND      B1.IMDG_UN_NO = B4.IMDG_UN_NO (+)" ).append("\n"); 
		query.append("AND      B1.IMDG_UN_NO_SEQ = B2.IMDG_UN_NO_SEQ (+)" ).append("\n"); 
		query.append("AND      B1.IMDG_UN_NO_SEQ = B4.IMDG_UN_NO_SEQ (+)" ).append("\n"); 
		query.append("AND      B2.IMDG_SPCL_PROVI_NO(+) = 274" ).append("\n"); 
		query.append("AND	     B1.IMDG_UN_NO LIKE @[imdg_un_no]||'%'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#if (${imdg_subs_rsk_lbl_cd} == 'Y')    " ).append("\n"); 
		query.append("	GROUP BY IMDG_UN_NO, IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	GROUP BY IMDG_UN_NO, IMDG_CLSS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}