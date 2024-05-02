/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOcheckCntrHoldRemvQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.07 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOcheckCntrHoldRemvQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkCntrHoldRemvQty
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOcheckCntrHoldRemvQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOcheckCntrHoldRemvQtyRSQL").append("\n"); 
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
		query.append("	SELECT NVL(SUM(" ).append("\n"); 
		query.append("	               CASE WHEN TB.HOLD_QTY <= TB.REMV_QTY THEN 0" ).append("\n"); 
		query.append("	                    ELSE 1" ).append("\n"); 
		query.append("	                END" ).append("\n"); 
		query.append("	          ),0) AS HOLD_REMV_QTY" ).append("\n"); 
		query.append("	  FROM (" ).append("\n"); 
		query.append("			SELECT SUM(HOLD.CNTR_QTY) AS HOLD_QTY" ).append("\n"); 
		query.append("			      ,(" ).append("\n"); 
		query.append("					SELECT SUM(RS1.CNTR_QTY)" ).append("\n"); 
		query.append("					  FROM BKG_CSTMS_ADV_CNTR_RSLT RS1" ).append("\n"); 
		query.append("					 WHERE RS1.CNT_CD = 'US'" ).append("\n"); 
		query.append("					   AND RS1.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("					   AND RS1.CNTR_NO LIKE TRIM(@[cntr_no])||'%'" ).append("\n"); 
		query.append("					   AND HOLD.REMV_CD LIKE '%' ||  RS1.DSPO_CD || '%'" ).append("\n"); 
		query.append("					) REMV_QTY" ).append("\n"); 
		query.append("			      ,HOLD.DSPO_CD" ).append("\n"); 
		query.append("			  FROM (" ).append("\n"); 
		query.append("					SELECT RS.CNTR_QTY" ).append("\n"); 
		query.append("					      ,RS.DSPO_CD" ).append("\n"); 
		query.append("					      ,CD.ATTR_CTNT4 AS REMV_CD" ).append("\n"); 
		query.append("					  FROM BKG_CSTMS_ADV_CNTR_RSLT RS" ).append("\n"); 
		query.append("					      ,BKG_CSTMS_CD_CONV_CTNT CD" ).append("\n"); 
		query.append("					 WHERE RS.CNT_CD = 'US'" ).append("\n"); 
		query.append("					   AND RS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("					   AND RS.CNTR_NO LIKE TRIM(@[cntr_no])||'%'" ).append("\n"); 
		query.append("					   AND RS.CNT_CD = CD.CNT_CD" ).append("\n"); 
		query.append("					   AND RS.DSPO_CD = CD.ATTR_CTNT3" ).append("\n"); 
		query.append("					   AND CD.CSTMS_DIV_ID = 'CARGO_RLS_H_CD'" ).append("\n"); 
		query.append("					) HOLD" ).append("\n"); 
		query.append("			GROUP BY HOLD.DSPO_CD, HOLD.REMV_CD" ).append("\n"); 
		query.append("			) TB" ).append("\n"); 

	}
}