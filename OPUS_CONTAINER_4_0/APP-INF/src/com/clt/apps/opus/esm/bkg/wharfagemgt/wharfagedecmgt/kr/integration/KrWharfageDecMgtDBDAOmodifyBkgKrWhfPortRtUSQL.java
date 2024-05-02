/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmodifyBkgKrWhfPortRtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.23 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmodifyBkgKrWhfPortRtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * U
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmodifyBkgKrWhfPortRtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_rto_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feu_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("teu_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_amt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_blk_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("feu_amt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_amt_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.korea.integration ").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmodifyBkgKrWhfPortRtUSQL").append("\n"); 
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
		query.append("UPDATE BKG_KR_WHF_PORT_RT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("CNTR_BLK_DIV_CD = @[cntr_blk_div_cd]" ).append("\n"); 
		query.append(",PORT_CD         = @[port_cd]" ).append("\n"); 
		query.append(",IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append(",DC_RTO_NO       = @[dc_rto_no]" ).append("\n"); 
		query.append(",TEU_PRC         = @[teu_prc]" ).append("\n"); 
		query.append(",FEU_PRC         = @[feu_prc]" ).append("\n"); 
		query.append(",HC_PRC          = @[hc_prc]" ).append("\n"); 
		query.append(",TEU_AMT_RT      = @[teu_amt_rt]" ).append("\n"); 
		query.append(",FEU_AMT_RT      = @[feu_amt_rt]" ).append("\n"); 
		query.append(",HC_AMT_RT       = @[hc_amt_rt]" ).append("\n"); 
		query.append(",UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR_BLK_DIV_CD = @[cntr_blk_div_cd]" ).append("\n"); 
		query.append("AND PORT_CD         = @[port_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND DC_RTO_NO       = @[dc_rto_no]" ).append("\n"); 

	}
}