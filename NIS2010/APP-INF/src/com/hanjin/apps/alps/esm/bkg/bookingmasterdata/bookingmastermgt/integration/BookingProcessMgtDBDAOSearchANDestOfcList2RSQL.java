/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingProcessMgtDBDAOSearchANDestOfcList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.02.13 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOSearchANDestOfcList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0374  저장을 위한  조회			
	  * </pre>
	  */
	public BookingProcessMgtDBDAOSearchANDestOfcList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOSearchANDestOfcList2RSQL").append("\n"); 
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
		query.append("/* HQ가 EQ에 존재하는지여부*/" ).append("\n"); 
		query.append("SELECT EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("    , HNDL_OFC_CD" ).append("\n"); 
		query.append("    , DEST_OFC_CNTC_CD" ).append("\n"); 
		query.append("FROM   BKG_AN_DEST_OFC_STUP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EQ_CTRL_OFC_CD = @[p_hndl_ofc_cd]  /* P_HQ*/" ).append("\n"); 
		query.append("AND EQ_CTRL_OFC_CD != HNDL_OFC_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* EQ에 EQ또는 HQ에 존재하는지여부*/" ).append("\n"); 
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("            , HNDL_OFC_CD" ).append("\n"); 
		query.append("            , DEST_OFC_CNTC_CD" ).append("\n"); 
		query.append("        FROM   BKG_AN_DEST_OFC_STUP" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND EQ_CTRL_OFC_CD > ' '" ).append("\n"); 
		query.append("        AND HNDL_OFC_CD > ' '" ).append("\n"); 
		query.append("        AND @[p_eq_ctrl_ofc_cd] IN (EQ_CTRL_OFC_CD ,HNDL_OFC_CD)  /* P_EQ */" ).append("\n"); 
		query.append("--        AND EQ_CTRL_OFC_CD != HNDL_OFC_CD" ).append("\n"); 
		query.append("        MINUS" ).append("\n"); 
		query.append("        SELECT EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("            , HNDL_OFC_CD" ).append("\n"); 
		query.append("            , DEST_OFC_CNTC_CD" ).append("\n"); 
		query.append("        FROM   BKG_AN_DEST_OFC_STUP" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND EQ_CTRL_OFC_CD = @[p_eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append("        AND HNDL_OFC_CD    = @[p_hndl_ofc_cd]" ).append("\n"); 
		query.append("        AND DEST_OFC_CNTC_CD IN ('I','D')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}