/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcopyBkgTroXterIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.08 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOcopyBkgTroXterIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcopyBkgTroXterIfCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into  bkg_tro_xter_if(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",IF_SEQ" ).append("\n"); 
		query.append(",IF_DT" ).append("\n"); 
		query.append(",ORD_NO" ).append("\n"); 
		query.append(",ACK_STS_CD" ).append("\n"); 
		query.append(",RQST_ORD_MSG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",IF_SEQ" ).append("\n"); 
		query.append(",IF_DT" ).append("\n"); 
		query.append(",ORD_NO" ).append("\n"); 
		query.append(",ACK_STS_CD" ).append("\n"); 
		query.append(",RQST_ORD_MSG" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from  bkg_tro_xter_if" ).append("\n"); 
		query.append("where bkg_no =  @[bkg_no]" ).append("\n"); 
		query.append("and tro_seq = @[tro_seq]" ).append("\n"); 
		query.append("and rtn_tro_flg = @[rtn_tro_flg]" ).append("\n"); 
		query.append("and io_bnd_cd = 'O'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration ").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcopyBkgTroXterIfCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}