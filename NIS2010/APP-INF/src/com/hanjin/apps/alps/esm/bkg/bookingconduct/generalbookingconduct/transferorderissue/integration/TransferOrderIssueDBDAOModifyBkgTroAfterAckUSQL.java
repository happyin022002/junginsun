/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyBkgTroAfterAckUSQL.java
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

public class TransferOrderIssueDBDAOModifyBkgTroAfterAckUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOModifyBkgTroAfterAckUSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyBkgTroAfterAckUSQL(){
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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyBkgTroAfterAckUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TRO" ).append("\n"); 
		query.append("   SET (VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , POL_CD" ).append("\n"); 
		query.append("       , POD_CD" ).append("\n"); 
		query.append("       , TRO_BKG_NO" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       ) = (SELECT /*+INDEX(XPKBKG_VVD BKG_VVD) */" ).append("\n"); 
		query.append("					VSL_CD" ).append("\n"); 
		query.append("					, SKD_VOY_NO" ).append("\n"); 
		query.append("					, SKD_DIR_CD" ).append("\n"); 
		query.append("					, POL_CD" ).append("\n"); 
		query.append("					, POD_CD" ).append("\n"); 
		query.append("					, BKG_NO" ).append("\n"); 
		query.append("					, 'MIG_USER' UPD_USR_ID" ).append("\n"); 
		query.append("					, sysdate UPD_DT" ).append("\n"); 
		query.append("			FROM BKG_VVD" ).append("\n"); 
		query.append("			WHERE BKG_NO = TRIM(@[bkg_no])" ).append("\n"); 
		query.append("			AND VSL_PRE_PST_CD||VSL_SEQ = (SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) " ).append("\n"); 
		query.append("											FROM BKG_VVD" ).append("\n"); 
		query.append("			                                WHERE BKG_NO = TRIM(@[bkg_no])" ).append("\n"); 
		query.append("            			                    GROUP BY BKG_NO)" ).append("\n"); 
		query.append(" 			)" ).append("\n"); 
		query.append(" WHERE BKG_NO       = TRIM(@[bkg_no])" ).append("\n"); 
		query.append("   AND IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("   AND RTN_TRO_FLG  = NVL((SELECT 'Y'" ).append("\n"); 
		query.append("				           FROM BKG_TRO TRO" ).append("\n"); 
		query.append("			    	      WHERE TRO.BKG_NO 		= TRIM(@[bkg_no])" ).append("\n"); 
		query.append("							AND TRO.TRO_SEQ 	= TRIM(@[tro_seq])" ).append("\n"); 
		query.append("			        	    AND TRO.IO_BND_CD 	= 'O'" ).append("\n"); 
		query.append("				            AND TRO.RTN_TRO_FLG = 'Y'" ).append("\n"); 
		query.append("			    	        AND TRO.CXL_FLG 	= 'N'" ).append("\n"); 
		query.append("			        	    AND TRO.VSL_CD  	IS NULL" ).append("\n"); 
		query.append("			            	AND TRO.RQST_DT 	IS NOT NULL), 'N')" ).append("\n"); 
		query.append("   AND TRO_SEQ      = TRIM(@[tro_seq])" ).append("\n"); 

	}
}