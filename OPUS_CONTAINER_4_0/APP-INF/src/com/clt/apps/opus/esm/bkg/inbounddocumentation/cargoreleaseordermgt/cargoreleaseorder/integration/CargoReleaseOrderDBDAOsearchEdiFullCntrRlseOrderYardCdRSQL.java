/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderYardCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderYardCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderYardCd
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderYardCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderYardCdRSQL").append("\n"); 
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
		query.append("SELECT  NVL(B.SNDR_TRD_PRNR_ID, 'NISBKG')                                    AS SEND_ID    -- EDI Send ID" ).append("\n"); 
		query.append("       ,NVL(B.RCVR_TRD_PRNR_ID,'XXX')                                        AS RECEIVER_ID    -- EDI Receiver ID" ).append("\n"); 
		query.append("       ,TO_CHAR(SYSDATE, 'DDMONRRRR', 'NLS_DATE_LANGUAGE = ENGLISH')         AS SYS_DATE     -- TO Date    " ).append("\n"); 
		query.append(" FROM BKG_EDI_SUB_LNK_MSG A, BKG_EDI_TRD_PRNR_SUB_LNK B" ).append("\n"); 
		query.append(" WHERE A.EDI_MSG_IND_CD = '11'  -- Full Cargo Indicator (0 : Null, 1 : FO, 2 : FOC)" ).append("\n"); 
		query.append(" AND A.MSG_TP_DESC='1'" ).append("\n"); 
		query.append(" AND A.EDI_MSG_TP_ID='COREOR'  -- EDI Message Type. ex) 301, COPARN, COPRAR" ).append("\n"); 
		query.append(" AND A.TRD_PRNR_SUB_LNK_SEQ = B.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append(" AND B.EDI_SND_FLG='Y'" ).append("\n"); 
		query.append(" AND B.PRNR_SUB_LNK_DIV_CD = '1'  -- Classification of Sublink.  1:customer, 2:yard, 3:terminal, 4:vendor " ).append("\n"); 
		query.append(" AND B.PRNR_SUB_LNK_CD = @[yd_cd]" ).append("\n"); 

	}
}