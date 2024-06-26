/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddBkgEurTroDgSeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.20 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOAddBkgEurTroDgSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOAddBkgEurTroDgSeqCSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddBkgEurTroDgSeqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tro_dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOAddBkgEurTroDgSeqCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EUR_TRO_DG_SEQ (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	TRO_DCGO_SEQ" ).append("\n"); 
		query.append(",   DCGO_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[bkg_no]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[tro_seq]" ).append("\n"); 
		query.append(",   NVL((SELECT /*+ INDEX_DESC(BKG_EUR_TRO_DG_SEQ XPKBKG_EUR_TRO_DG_SEQ) */" ).append("\n"); 
		query.append("TRO_DCGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO_DG_SEQ" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD    = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO_SEQ      = @[tro_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1), 0) + 1" ).append("\n"); 
		query.append(",   @[tro_dcgo_seq]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}