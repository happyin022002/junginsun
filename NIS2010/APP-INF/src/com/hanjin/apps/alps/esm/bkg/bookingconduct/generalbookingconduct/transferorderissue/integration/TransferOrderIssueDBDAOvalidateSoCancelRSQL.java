/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOvalidateSoCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOvalidateSoCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOvalidateSoCancel
	  * </pre>
	  */
	public TransferOrderIssueDBDAOvalidateSoCancelRSQL(){
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
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOvalidateSoCancelRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM BKG_TRO_DTL DTL" ).append("\n"); 
		query.append(", TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE DTL.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND DTL.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("-- AND DTL.RTN_TRO_FLG = @[rtn_tro_flg]" ).append("\n"); 
		query.append("AND DTL.TRO_SEQ 	   = @[tro_seq]" ).append("\n"); 
		query.append("AND DTL.BKG_NO      = SO.BKG_NO" ).append("\n"); 
		query.append("AND DTL.IO_BND_CD   = SO.TRSP_BND_CD" ).append("\n"); 
		query.append("AND DTL.TRO_SEQ     = SO.TRO_SEQ" ).append("\n"); 
		query.append("AND DTL.TRO_SUB_SEQ = SO.TRO_SUB_SEQ" ).append("\n"); 
		query.append("AND 'N'             = SO.DELT_FLG" ).append("\n"); 
		query.append("AND SO.TRSP_SO_OFC_CTY_CD||SO.TRSP_SO_SEQ IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY DTL.TRO_SEQ, DTL.TRO_SUB_SEQ" ).append("\n"); 

	}
}