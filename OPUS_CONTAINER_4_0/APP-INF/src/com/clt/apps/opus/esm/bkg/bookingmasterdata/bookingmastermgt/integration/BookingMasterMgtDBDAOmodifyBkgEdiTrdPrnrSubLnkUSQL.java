/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOmodifyBkgEdiTrdPrnrSubLnkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.09 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOmodifyBkgEdiTrdPrnrSubLnkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgEdiTrdPrnrSubLnk
	  * </pre>
	  */
	public BookingMasterMgtDBDAOmodifyBkgEdiTrdPrnrSubLnkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_prnr_sub_lnk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_sub_lnk_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_sub_lnk_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOmodifyBkgEdiTrdPrnrSubLnkUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EDI_TRD_PRNR_SUB_LNK" ).append("\n"); 
		query.append("SET    PRNR_SUB_LNK_DIV_CD = NVL(@[prnr_sub_lnk_div_cd],PRNR_SUB_LNK_DIV_CD)" ).append("\n"); 
		query.append(", PRNR_SUB_LNK_CD   = NVL(@[prnr_sub_lnk_cd]    ,PRNR_SUB_LNK_CD    )" ).append("\n"); 
		query.append(", SNDR_TRD_PRNR_ID  = NVL(@[sndr_trd_prnr_id]   ,SNDR_TRD_PRNR_ID   )" ).append("\n"); 
		query.append(", RCVR_TRD_PRNR_ID  = NVL(@[rcvr_trd_prnr_id]   ,RCVR_TRD_PRNR_ID   )" ).append("\n"); 
		query.append(", PRNR_PORT_CD      = NVL(@[prnr_port_cd]       ,PRNR_PORT_CD       )" ).append("\n"); 
		query.append(", EDI_SND_FLG       = NVL(@[edi_snd_flg]        ,EDI_SND_FLG        )" ).append("\n"); 
		query.append(", UPD_USR_ID        = NVL(@[upd_usr_id]         ,'SYSTEM'           )" ).append("\n"); 
		query.append(", UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE  TRD_PRNR_SUB_LNK_SEQ = @[trd_prnr_sub_lnk_seq]" ).append("\n"); 

	}
}