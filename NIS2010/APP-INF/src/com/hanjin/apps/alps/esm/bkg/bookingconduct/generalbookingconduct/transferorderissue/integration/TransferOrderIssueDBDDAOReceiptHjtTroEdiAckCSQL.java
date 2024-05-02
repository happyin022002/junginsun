/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransferOrderIssueDBDDAOReceiptHjtTroEdiAckCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.07.08 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDDAOReceiptHjtTroEdiAckCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOReceiptHjtTroEdiAckISQL
	  * 2010.10.19 신자영 [CHM-201006495-01] TRO (KOR) Status 변경 (User ID 및 정렬 순서)
	  * </pre>
	  */
	public TransferOrderIssueDBDDAOReceiptHjtTroEdiAckCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ack_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ord_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDDAOReceiptHjtTroEdiAckCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TRO_XTER_IF" ).append("\n"); 
		query.append("       (BKG_NO" ).append("\n"); 
		query.append("       , IO_BND_CD" ).append("\n"); 
		query.append("       , RTN_TRO_FLG" ).append("\n"); 
		query.append("       , TRO_SEQ" ).append("\n"); 
		query.append("       , IF_SEQ" ).append("\n"); 
		query.append("       , IF_DT" ).append("\n"); 
		query.append("       , ORD_NO" ).append("\n"); 
		query.append("       , ACK_STS_CD" ).append("\n"); 
		query.append("       , RQST_ORD_MSG" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT)" ).append("\n"); 
		query.append("SELECT TRIM(@[bkg_no])" ).append("\n"); 
		query.append("       , NVL(@[io_bnd_cd], 'O')" ).append("\n"); 
		query.append("       , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("	           FROM BKG_TRO TRO" ).append("\n"); 
		query.append("    	      WHERE TRO.BKG_NO 		= TRIM(@[bkg_no])" ).append("\n"); 
		query.append("				AND TRO.TRO_SEQ 	= TRIM(@[tro_seq])" ).append("\n"); 
		query.append("        	    AND TRO.IO_BND_CD 	= 'O'" ).append("\n"); 
		query.append("	            AND TRO.RTN_TRO_FLG = 'Y'" ).append("\n"); 
		query.append("    	        AND TRO.CXL_FLG 	= 'N'" ).append("\n"); 
		query.append("        	    AND TRO.VSL_CD  	IS NULL" ).append("\n"); 
		query.append("            	AND TRO.RQST_DT 	IS NOT NULL), 'N')" ).append("\n"); 
		query.append("       , TRIM(@[tro_seq])" ).append("\n"); 
		query.append("       , NVL((SELECT MAX(IF_SEQ) + 1" ).append("\n"); 
		query.append("	   	    FROM BKG_TRO_XTER_IF   " ).append("\n"); 
		query.append("		   WHERE BKG_NO       = TRIM(@[bkg_no])" ).append("\n"); 
		query.append("		     AND RTN_TRO_FLG  = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("							           FROM BKG_TRO TRO" ).append("\n"); 
		query.append("						    	      WHERE TRO.BKG_NO 		= TRIM(@[bkg_no])" ).append("\n"); 
		query.append("										AND TRO.TRO_SEQ 	= TRIM(@[tro_seq])" ).append("\n"); 
		query.append("						        	    AND TRO.IO_BND_CD 	= 'O'" ).append("\n"); 
		query.append("							            AND TRO.RTN_TRO_FLG = 'Y'" ).append("\n"); 
		query.append("							   	        AND TRO.CXL_FLG 	= 'N'" ).append("\n"); 
		query.append("						        	    AND TRO.VSL_CD  	IS NULL" ).append("\n"); 
		query.append("						            	AND TRO.RQST_DT 	IS NOT NULL), 'N')" ).append("\n"); 
		query.append("		     AND IO_BND_CD    = NVL(@[io_bnd_cd], 'O')" ).append("\n"); 
		query.append("		     AND TRO_SEQ      = TRIM(@[tro_seq])), 1)" ).append("\n"); 
		query.append("       , TO_DATE(@[if_dt], 'RRMMDDHH24MI')" ).append("\n"); 
		query.append("       , @[ord_no]" ).append("\n"); 
		query.append("       , @[ack_sts_cd]" ).append("\n"); 
		query.append("       , SUBSTR(@[rqst_ord_msg], 1, (LENGTH(@[rqst_ord_msg])- 1))" ).append("\n"); 
		query.append("       , NVL((SELECT RQST_USR_ID" ).append("\n"); 
		query.append("	   	    FROM BKG_TRO " ).append("\n"); 
		query.append("		   WHERE BKG_NO       = TRIM(@[bkg_no])" ).append("\n"); 
		query.append("		     AND RTN_TRO_FLG  = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("							           FROM BKG_TRO TRO" ).append("\n"); 
		query.append("						    	      WHERE TRO.BKG_NO 		= TRIM(@[bkg_no])" ).append("\n"); 
		query.append("										AND TRO.TRO_SEQ 	= TRIM(@[tro_seq])" ).append("\n"); 
		query.append("						        	    AND TRO.IO_BND_CD 	= 'O'" ).append("\n"); 
		query.append("							            AND TRO.RTN_TRO_FLG = 'Y'" ).append("\n"); 
		query.append("						    	        AND TRO.CXL_FLG 	= 'N'" ).append("\n"); 
		query.append("						        	    AND TRO.VSL_CD  	IS NULL" ).append("\n"); 
		query.append("						            	AND TRO.RQST_DT 	IS NOT NULL), 'N')" ).append("\n"); 
		query.append("		     AND IO_BND_CD    = NVL(@[io_bnd_cd], 'O')" ).append("\n"); 
		query.append("		     AND TRO_SEQ      = TRIM(@[tro_seq])), 1)" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("       , 'MIG_USER'" ).append("\n"); 
		query.append("       , sysdate" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}